package reflaction.getshow;

import java.lang.reflect.Field;

public class ObjToSql {
    public static void main(String[] args) {
        String cn = "student";
        StringBuffer ss = new StringBuffer("create table car (");

        try {
            Class classname = Class.forName(cn);
            Field field[] = classname.getDeclaredFields();
            for (Field f : field) {
                Class type = f.getType();
                String name = f.getName();
                switch (type.getName()) {
                    case "java.lang.String":
                        ss.append(name + " varchar(" + 30 + "),");
                        break;

                    case "int":
                        ss.append(name + " int ,");

                }

            }
            String Sql = ss.substring(0, ss.length() - 1) + ");";
            System.out.println(Sql);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
