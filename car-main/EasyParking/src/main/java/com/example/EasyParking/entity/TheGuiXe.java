package com.example.EasyParking.entity;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "THEGUIXE")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TheGuiXe {

    @Id
    @Column(name = "MATHE", length = 255)
    private String maThe;

    @Column(name = "THOIGIANCAP", nullable = false)
    private LocalDateTime thoiGianCap;

    @ManyToOne
    @JoinColumn(name = "MANHANVIEN", nullable = false)
    private NhanVien nhanVien;

    @Column(name = "CREATED_BY", nullable = false)
    private String createdBy;

    @Column(name = "CREATED_DATE", nullable = false)
    private LocalDateTime createdDate;

    @Column(name = "LAST_MODIFIED_BY")
    private String lastModifiedBy;

    @Column(name = "LAST_MODIFIED_DATE")
    private LocalDateTime lastModifiedDate;

    @Column(name = "DELETE_FLAG", nullable = false)
    private Integer deleteFlag;
}

