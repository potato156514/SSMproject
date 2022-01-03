package project.DAO;

import org.apache.ibatis.annotations.Param;
import project.Beans.MyShiYan;
import project.Beans.Shiyaninf;

import java.util.ArrayList;

public interface ShiyanDAO {
    ArrayList<Shiyaninf> selectAllShiyan();
    boolean  shiyanChoose(@Param("stuId") int stuId,@Param("shiyanId") int shiyanId);
    ArrayList<MyShiYan> selectMyShiYan(@Param("stuId") int stuId);
    boolean tuixuanById(@Param("stuId") int stuId,@Param("shiyanId") int shiyanId);
}
