package com.example.bank;

import management.BankManagement;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/bank")
public class Bank {
    ArrayList<BankManagement> tasks = new ArrayList<>();

    @GetMapping("/get")
    public ArrayList<BankManagement> getTasks() {

        return tasks;
    }

    @PostMapping("/add")
    public ArrayList<BankManagement> addTask(@RequestBody BankManagement bankManagement) {
        tasks.add(bankManagement);
        return tasks;
    }

    @PutMapping("/update/{index}")
    public ArrayList<BankManagement> updateTask(@PathVariable int index, @RequestBody BankManagement bankManagement) {
        tasks.set(index, bankManagement);
        return tasks;
    }

    @DeleteMapping("/delete/{index}")
    public ArrayList<BankManagement> deleteTask(@PathVariable int index) {
        tasks.remove(index);
        return tasks;
    }
    @PutMapping("/Deposit/{index}")
    public ArrayList<BankManagement> Deposit(@PathVariable int index, @RequestBody double balance) {
        for (BankManagement b:tasks
             ) {
            b.setBalance(b.getBalance()+balance);
        }


        return tasks;
}
    @PutMapping("/Withdraw/{index}")
    public ArrayList<BankManagement> Withdraw(@PathVariable int index, @RequestBody BankManagement bankManagement) {
        tasks.set(index, bankManagement);
        return tasks;
    }
}