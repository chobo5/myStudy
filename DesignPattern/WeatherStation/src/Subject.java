public interface Subject {
    public abstract void registerObserver(Observer observer);
    public abstract  void removeOberver(Observer observer);
    public abstract  void notifyObserver(); //모든 옵저버에게 알림
}
