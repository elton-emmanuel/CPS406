import java.util.ArrayList;

/**
 * Created by Rony Verch on 2018-03-13.
 */
public class Session
{
    private int month;
    private String[][] members = null;

    public Session(int newMonth) {
        this.month = newMonth;
    }

    public void AddMember(String name, String number, String isPaid, String address) {
        if(members == null){
            members = new String[1][];

            members[0] = new String[4];
            members[0][0] = name;
            members[0][1] = number;
            members[0][2] = isPaid;
            members[0][3] = address;
        }
        else
        {
            members = AddIndex(name, number, isPaid, address);
        }
    }

    public void RemoveMember(String name) {
        int remove = 0;
        boolean found = false;

        for (int i = 0; i < members.length; i++)
        {
            if (members[i][0].equals(name))
            {
                remove = i;
                i = members.length;
                found = true;
            }
        }

        if (found)
        {
            if (members.length > 1)
            {
                members = RemoveIndex(remove);
            }
            else
            {
                members = null;
            }
        }
    }

    public String[][] GetMemberReportInfo() {
        String[][] temp = new String[members.length][2];

        for (int i = 0; i < temp.length; i++)
        {
            for (int j = 0; j < temp[i].length; j++)
            {
                temp[i][j] = members[i][j];
            }
        }

        return temp;
    }

    private String[][] RemoveIndex(int remove) {
        String[][] temp = new String[members.length - 1][4];
        int count = 0;

        for (int i = 0; i < members.length; i++)
        {
            if (i != remove)
            {
                for (int j = 0; j < temp[i].length; j++)
                {
                    temp[count][j] = members[i][j];
                }

                count++;
            }
        }

        return temp;
    }

    private String[][] AddIndex(String name, String number, String isPaid, String address) {
        String[][] temp = new String[members.length + 1][4];

        for (int i = 0; i < members.length; i++)
        {
            for (int j = 0; j < temp[i].length; j++)
            {
                temp[i][j] = members[i][j];
            }
        }

        temp[members.length][0] = name;
        temp[members.length][1] = number;
        temp[members.length][2] = isPaid;
        temp[members.length][3] = address;

        return temp;
    }
}