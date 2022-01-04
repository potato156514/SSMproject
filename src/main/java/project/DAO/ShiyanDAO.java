package project.DAO;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.ibatis.annotations.Param;
import org.springframework.format.annotation.DateTimeFormat;
import project.Beans.MyShiYan;
import project.Beans.Shiyaninf;

import java.util.ArrayList;
import java.util.Date;

public interface ShiyanDAO {
    ArrayList<Shiyaninf> selectAllShiyan();
    boolean  shiyanChoose(@Param("stuId") int stuId,@Param("shiyanId") int shiyanId);
    ArrayList<MyShiYan> selectMyShiYan(@Param("stuId") int stuId);
    boolean tuixuanById(@Param("stuId") int stuId,@Param("shiyanId") int shiyanId);
    boolean checkIfExist(@Param("stuId")int stuId, @Param("shiyanId")int shiyanId);
    boolean addShiyYanRenSHu(@Param("ShiyanId") int shiyanId);
    boolean jianShiYanRenSHu(@Param("ShiyanId") int shiyanId);
}
