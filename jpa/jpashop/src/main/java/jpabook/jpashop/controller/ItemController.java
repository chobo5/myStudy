package jpabook.jpashop.controller;

import jpabook.jpashop.domain.item.Book;
import jpabook.jpashop.domain.item.Item;
import jpabook.jpashop.service.ItemService;
import jpabook.jpashop.service.UpdateItemDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ItemController {
    private final ItemService itemService;

    @GetMapping("/items/new")
    public String createItemFrom(Model model) {
        model.addAttribute("form", new BookForm());
        return "items/createItemForm";
    }

    @PostMapping("/items/new")
    public String createItem(BookForm form) {
        Book book = new Book();
        book.setId(form.getId());
        book.setName(form.getName());
        book.setAuthor(form.getAuthor());
        book.setPrice(form.getPrice());
        book.setStockQuantity(form.getStockQuantity());
        book.setIsbn(form.getIsbn());

        itemService.saveItem(book);
        return "redirect:/items";
    }

    @GetMapping("/items")
    public String itemList(Model model) {
        List<Item> itemList = itemService.findItems();
        model.addAttribute("items", itemList);
        return "items/itemList";
    }

    @GetMapping("/items/{itemId}/edit")
    public String editItemForm(Model model, @PathVariable("itemId") Long itemId) {
        Book item = (Book) itemService.findItem(itemId);
        BookForm form = new BookForm();
        form.setId(item.getId());
        form.setAuthor(item.getAuthor());
        form.setName(item.getName());
        form.setPrice(item.getPrice());
        form.setStockQuantity(item.getStockQuantity());
        form.setIsbn(item.getIsbn());

        model.addAttribute("form", form);
        return "items/updateItemForm";
    }

    @PostMapping("/items/{itemId}/edit")
    public String editItem(@ModelAttribute("form") BookForm form) {
//        Book book = new Book(); //준영속 엔티티(직접 생성한 객체 - 관리되지 않음)
//        book.setId(form.getId());
//        book.setName(form.getName());
//        book.setAuthor(form.getAuthor());
//        book.setPrice(form.getPrice());
//        book.setStockQuantity(form.getStockQuantity());
//        book.setIsbn(form.getIsbn());
        UpdateItemDto dto = new UpdateItemDto(form.getId(), form.getName(), form.getAuthor(), form.getPrice(), form.getStockQuantity(), form.getIsbn());
        itemService.updateItem(dto);

        return "redirect:/items";
    }
}
