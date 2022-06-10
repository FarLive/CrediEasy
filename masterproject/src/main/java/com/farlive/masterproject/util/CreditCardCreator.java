package com.farlive.masterproject.util;

import java.security.SecureRandom;
import java.util.concurrent.ThreadLocalRandom;

import com.farlive.masterproject.entidades.CreditCard;
import com.farlive.masterproject.entidades.Customer;

public class CreditCardCreator {
    
    private final Customer customer;
    private final SecureRandom sr;
    private final String bin;

    public CreditCardCreator(Customer customer) {
        this.customer = customer;
        sr = new SecureRandom();
        bin = "415231";
    }

    public CreditCard create(String type) {
        CreditCard creditCard = new CreditCard();
        creditCard.setId(4);
        creditCard.setCustomer(customer);
        creditCard.setNumber(generate());
        creditCard.setCvv(String.valueOf(ThreadLocalRandom.current().nextInt(100, 1000)));
        creditCard.setDate("06/26");
        creditCard.setType(type);
        return creditCard;
    }

    private String generate() {
        int [] ccArray;
        do {
            ccArray = new int[16];
            char [] binArray = bin.toCharArray();
            for(int i = 0; i < 16; i++) 
                ccArray[i] = i < binArray.length ? Character.getNumericValue(binArray[i]) : ((sr.nextInt(9) + 1));
        } while (luhn(ccArray));
        StringBuilder sBuilder = new StringBuilder();
        for(int x : ccArray)
            sBuilder.append(String.valueOf(x));
        return sBuilder.toString();
    }

    private boolean luhn(int [] preCC) {
        int ccTrue = 0;
        int cc[] = preCC.clone();
        for (int j = 0; j < 16; j++) {
            if (j % 2 == 0) {
                cc[j] *= 2;
                int temp = (String.valueOf(cc[j]).length());
                if (temp > 1) {
                    int valores = 0;
                    for (int k = 0; k < temp; k++) {
                        valores += Integer.parseInt(Character.toString(String.valueOf(cc[j]).charAt(k)));
                    }
                    cc[j] = valores;
                }
            }
            ccTrue += cc[j];
        }
        return  (ccTrue % 10 == 0);
    }

    @Override
    public String toString() {
        return "Bin = {" + bin + "}";
    }
}