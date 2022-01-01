package project.Beans;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Shiyaninf {
    private int id;
    private String name;
    private int teacherId;
    private Data startTime;
    private Data endTime;
    private int stulimit;
    private int stunum;
    private int state;
}
