package com.ita.edu.teachua.data.challenges;

import lombok.Data;
import java.io.File;

@Data
public class Challenge {

    String sequenceNumber ;
    String name ;
    String title ;
    String description ;
    File photo ;

}
