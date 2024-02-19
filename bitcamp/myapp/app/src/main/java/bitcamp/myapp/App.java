package bitcamp.myapp;

import bitcamp.menu.MenuGroup;
import bitcamp.myapp.dao.AssignmentDao;
import bitcamp.myapp.dao.AttachedFileDao;
import bitcamp.myapp.dao.BoardDao;
import bitcamp.myapp.dao.MemberDao;
import bitcamp.myapp.dao.mysql.AssignmentDaoImpl;
import bitcamp.myapp.dao.mysql.AttachedFileDaoImpl;
import bitcamp.myapp.dao.mysql.BoardDaoImpl;
import bitcamp.myapp.dao.mysql.MemberDaoImpl;

import bitcamp.util.Prompt;
import bitcamp.util.DBConnectionPool;
import bitcamp.util.TransactionManager;
import org.apache.catalina.WebResourceRoot;
import org.apache.catalina.connector.Connector;
import org.apache.catalina.core.StandardContext;
import org.apache.catalina.startup.Tomcat;
import org.apache.catalina.webresources.DirResourceSet;
import org.apache.catalina.webresources.StandardRoot;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class App {
    ExecutorService executorService = Executors.newCachedThreadPool();

    BoardDao boardDao;
    AttachedFileDao attachedFileDao;
    BoardDao greetingDao;
    AssignmentDao assignmentDao;
    MemberDao memberDao;

    MenuGroup mainMenu;
    DBConnectionPool connectionPool;
    TransactionManager txManager;

    App() {
        prepareDatabase();
    }

    public static void main(String[] args) throws Exception {
        System.out.println("과제관리 시스템 서버 실행!");

        // 톰캣 서버를 구동시키는 객체 준비
        Tomcat tomcat = new Tomcat();

        // 서버의 포트 번호 설정
        tomcat.setPort(8888);

        // 톰캣 서버를 실행하는 동안 사용할 임시 폴더 지정
        tomcat.setBaseDir("./temp");

        // 톰캣 서버의 연결 정보를 설정
        Connector connector = tomcat.getConnector();
        connector.setURIEncoding("UTF-8");

        // 톰캣 서버에 배포할 웹 애플리케이션의 환경 정보 준비
        StandardContext ctx = (StandardContext) tomcat.addWebapp(
                "/", // 컨텍스트 경로(웹 애플리케이션 경로)
                new File("src/main/webapp").getAbsolutePath() // 웹 애플리케이션 파일이 있는 실제 경로
        );
        ctx.setReloadable(true);

        // 웹 애플리케이션 기타 정보 설정
        WebResourceRoot resources = new StandardRoot(ctx);

        // 웹 애플리케이션의 서블릿 클래스 등록
        resources.addPreResources(new DirResourceSet(
                resources, // 루트 웹 애플리케이션 정보
                "/WEB-INF/classes", // 서블릿 클래스 파일의 위치 정보
                new File("build/classes/java/main").getAbsolutePath(), // 서블릿 클래스 파일이 있는 실제 경로
                "/" // 웹 애플리케이션 내부 경로
        ));

        // 웹 애플리케이션 설정 정보를 웹 애플리케이션 환경 정보에 등록
        ctx.setResources(resources);

        // 톰캣 서버 구동
        tomcat.start();

        // 톰캣 서버를 구동한 후 종료될 때까지 JVM을 끝내지 말고 기다린다.
        tomcat.getServer().await();

        System.out.println("서버 종료!");
    }

    void prepareDatabase() {
        try {
            connectionPool = new DBConnectionPool(
                    "jdbc:mysql://db-ld296-kr.vpc-pub-cdb.ntruss.com/studydb", "study", "Bitcamp!@#123");
            txManager = new TransactionManager(connectionPool);
            boardDao = new BoardDaoImpl(connectionPool);
            attachedFileDao = new AttachedFileDaoImpl(connectionPool);
            greetingDao = new BoardDaoImpl(connectionPool);
            assignmentDao = new AssignmentDaoImpl(connectionPool);
            memberDao = new MemberDaoImpl(connectionPool);

        } catch (Exception e) {
            System.out.println("통신 오류!");
            e.printStackTrace();
        }
    }



    void run() {
        try (ServerSocket serverSocket = new ServerSocket(8888)) {
            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("클라이언트 연결됨");
                executorService.execute(() -> processRequest(socket));
            }
        } catch (Exception e) {
            System.out.println("서버 소켓 생성 오류");
            e.printStackTrace();
        } finally {
            connectionPool.closeAll();
        }
    }

    void processRequest(Socket socket) {
        try (Socket s = socket;
             DataOutputStream out = new DataOutputStream(s.getOutputStream());
             DataInputStream in = new DataInputStream(s.getInputStream());
             Prompt prompt = new Prompt(in, out)) {

            while (true) {
                try {
                    mainMenu.execute(prompt);
                    prompt.print("[[quit]]");
                    prompt.end();
                } catch (Exception e) {
                    System.out.println("예외 발생");
                    e.printStackTrace();

                }
            }
        } catch (Exception e) {
            System.out.println("클라이언트 통신 오류");
            e.printStackTrace();
        }
    }
}
