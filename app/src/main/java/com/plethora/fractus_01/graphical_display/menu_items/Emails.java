package com.plethora.fractus_01.graphical_display.menu_items;

import com.plethora.fractus_01.graphical_display.graphical_model.home.ItemDistrict;

import java.util.Arrays;
import java.util.List;


public class Emails {

  public static List<ItemDistrict> fakeEmails() {
    return Arrays.asList(

            ItemDistrict.DistrictBuilder.builder()
                    .setUser("Макеевское лесничество")
                    .setSubject("Гомельская область")
                    .setPreview("Гомельский лесхоз")
                    .setDate("5 jun")
                    .build(),

            ItemDistrict.DistrictBuilder.builder()
                    .setUser("Ветковское лесничество")
                    .setSubject("Гомельская область")
                    .setPreview("Ветковский лесхоз")
                    .setDate("30 mai")
                    .build(),

            ItemDistrict.DistrictBuilder.builder()
                    .setUser("Ельское лесничество")
                    .setSubject("Гомельскя область")
                    .setPreview("Ельский лесхоз")
                    .setDate("30 mai")
                    //.setStared(true)
                    //.setUnread(true)   связано с выделением текста
                    .build(),

            ItemDistrict.DistrictBuilder.builder()
                    .setUser("Ильянское лесничество")
                    .setSubject("Минская область")
                    .setPreview("Вилейский лесхоз")
                    .setDate("18 mai")
                    //.setStared(false)
                    .build(),

            ItemDistrict.DistrictBuilder.builder()
                    .setUser("Завышанское лесничество")
                    .setSubject("Брестская область")
                    .setPreview("Пински лесхоз")
                    .setDate("5 jun")
                    .build(),

            ItemDistrict.DistrictBuilder.builder()
                    .setUser("Какое-то лесничество")
                    .setSubject("Какая-то область")
                    .setPreview("Какой-то лесхоз")
                    .setDate("30 mai")
                    .build(),

            ItemDistrict.DistrictBuilder.builder()
                    .setUser("Какое-то лесничество")
                    .setSubject("Какая-то область")
                    .setPreview("Какой-то лесхоз")
                    .setDate("30 mai")
                   // .setStared(true)
                   // .setUnread(true)
                    .build(),

            ItemDistrict.DistrictBuilder.builder()
                    .setUser("Какое-то лесничество")
                    .setSubject("Какая-то область")
                    .setPreview("Какой-то лесхоз")
                    .setDate("18 mai")
                  //  .setStared(false)
                    .build(),

            ItemDistrict.DistrictBuilder.builder()
                    .setUser("Какое-то лесничество")
                    .setSubject("Какая-то область")
                    .setPreview("Какой-то лесхоз")
                    .setDate("5 jun")
                    .build(),

            ItemDistrict.DistrictBuilder.builder()
                    .setUser("Какое-то лесничество")
                    .setSubject("Какая-то область")
                    .setPreview("Какой-то лесхоз")
                    .setDate("30 mai")
                    .build(),

            ItemDistrict.DistrictBuilder.builder()
                    .setUser("Какое-то лесничество")
                    .setSubject("Какая-то область")
                    .setPreview("Какой-то лесхоз")
                    .setDate("30 mai")
                 //   .setStared(true)
                 //   .setUnread(true)
                    .build(),

            ItemDistrict.DistrictBuilder.builder()
                    .setUser("Какое-то лесничество")
                    .setSubject("Какая-то область")
                    .setPreview("Какой-то лесхоз")
                    .setDate("18 mai")
                //    .setStared(false)
                    .build(),

            ItemDistrict.DistrictBuilder.builder()
                    .setUser("Какое-то лесничество")
                    .setSubject("Какая-то область")
                    .setPreview("Какой-то лесхоз")
                    .setDate("5 jun")
                    .build(),

            ItemDistrict.DistrictBuilder.builder()
                    .setUser("Какое-то лесничество")
                    .setSubject("Какая-то область")
                    .setPreview("Какой-то лесхоз")
                    .setDate("30 mai")
                    .build(),

            ItemDistrict.DistrictBuilder.builder()
                    .setUser("Какое-то лесничество")
                    .setSubject("Какая-то область")
                    .setPreview("Какой-то лесхоз")
                    .setDate("30 mai")
                 //   .setStared(true)
                 //   .setUnread(true)
                    .build(),

            ItemDistrict.DistrictBuilder.builder()
                    .setUser("Какое-то лесничество")
                    .setSubject("Какая-то область")
                    .setPreview("Какой-то лесхоз")
                    .setDate("18 mai")
                 //   .setStared(false)
                    .build()
    );


  }

}
