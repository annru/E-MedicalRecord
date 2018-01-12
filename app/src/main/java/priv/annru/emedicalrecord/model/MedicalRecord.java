package priv.annru.emedicalrecord.model;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created on 2018/1/12.
 *
 * @author 00224524  新建病历实体对象类
 */
@Entity
public class MedicalRecord {

    @Id
    private Long id;
    private String name;
    private String date;
    /**
     * 科室
     */
    private String department;
    /**
     * 诊断
     */
    private String diagnosis;
    /**
     * 病情
     */
    private String illness;

    @Generated(hash = 844173241)
    public MedicalRecord(Long id, String name, String date, String department,
                         String diagnosis, String illness) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.department = department;
        this.diagnosis = diagnosis;
        this.illness = illness;
    }

    @Generated(hash = 1635019519)
    public MedicalRecord() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return this.date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDepartment() {
        return this.department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getDiagnosis() {
        return this.diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public String getIllness() {
        return this.illness;
    }

    public void setIllness(String illness) {
        this.illness = illness;
    }


}
