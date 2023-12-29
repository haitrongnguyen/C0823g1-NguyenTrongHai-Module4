package com.example.songvalidate.model;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name = "song")
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @NotBlank(message = "Không được để trống")
    @Size(min = 10, max = 800, message = "Tên bài hát phải có độ dài từ 10-800 kí tự")
    @Pattern(regexp = "^[a-zA-Z0-9]+$", message = "Tên bài hát không được chứa kí tự đặc biệt")
    private String name;



    @NotBlank(message = "Không được để trống")
    @Size(min = 10, max = 300, message = "Nghệ sĩ thể hiện phải có độ dài từ 10-300 kí tự")
    @Pattern(regexp = "^[\\p{L}\\d ]+$", message = "Không chứa các kí tự đặc biệt như @;,.=-+, ….")
    private String singer;
    @NotBlank(message = "Không được để trống")
    @Size(min = 10, max = 1000, message = "Thể loại âm nhạc phải có độ dài từ 10-1000 kí tự")
    @Pattern(regexp = "^[\\p{L}\\d ]+$", message = "Không chứa các kí tự đặc biệt như @;,.=-+, …. ngoại trừ dấu phẩy")
    private String category;

    public Song() {
    }

//    public Song(Long id,@Size(max = 800,message = "Không nhập quá 800 kí tự") @NotBlank(message = "Không được để trống") @Pattern(regexp = "^[a-zA-Z0-9]*$") String name,
//                @Size(max = 300,message = "Không nhập quá 300 kí tự") @NotBlank(message = "Không được để trống") @Pattern(regexp = "^[a-zA-Z0-9]*$")String singer,
//                @Size(max = 1000,message = "Không nhập quá 1000 kí tự") @NotBlank(message = "Không được để trống") @Pattern(regexp = "^([a-zA-Z0-9]|,)*$")String category) {
//        this.id = id;
//        this.name = name;
//        this.singer = singer;
//        this.category = category;
//    }


//    public Song(Long id,
//                @Size
//                @NotBlank
//                @Pattern(regexp = "^[a-zA-Z0-9]*$")  String name,
//                @Size
//                @NotBlank
//                @Pattern(regexp = "^[a-zA-Z0-9]*$") String singer,
//                @Size
//                @NotBlank
//                @Pattern(regexp = "^([a-zA-Z0-9]|,)*$") String category) {
//        this.id = id;
//        this.name = name;
//        this.singer = singer;
//        this.category = category;
//    }


    public Song(Long id, String name, String singer, String category) {
        this.id = id;
        this.name = name;
        this.singer = singer;
        this.category = category;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
