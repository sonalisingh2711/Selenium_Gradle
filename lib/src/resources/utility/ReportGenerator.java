package utility;

import java.io.File;
import java.util.GregorianCalendar;
import java.io.FileWriter;
import java.io.BufferedWriter;
import org.testng.ITestResult;
import java.text.SimpleDateFormat;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class ReportGenerator {
    public static int testCaseCount = 0;
    public static int passTestCase = 0;
    public static int failTestCase = 0;
    public static int skipTestCase = 0;
    public static String resultFile = System.getProperty("user.dir")
            + "//src//resources//testOutput//customReport//TestReport.html";
    public static BufferedWriter bw;

    // It will generate HTML report for each test
    public static void generateReport(ITestResult result) {
        try {

            testCaseCount++;
            if (result.getStatus() == ITestResult.FAILURE) {
                updateResult(result.getTestClass().getName(), testCaseCount, result.getName().toString(),
                        "FAIL", "REASON:" + result.getThrowable().getMessage());
                failTestCase++;
            } else if (result.getStatus() == ITestResult.SUCCESS) {
                updateResult(result.getTestClass().getName(), testCaseCount, result.getName().toString(), "PASS", null);
                passTestCase++;
            } else {
                updateResult(result.getTestClass().getName(), testCaseCount, result.getName().toString(), "OTHER",
                        null);
                skipTestCase++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void updateResult(String className, int testCaseCount, String methodName, String response,
            String Exception) {
        try {

            String startDateTime = new SimpleDateFormat("MM-dd-yyyy_HH:ss").format(new GregorianCalendar().getTime());
            bw.write("<tr style='background-color:#D3D3D3;font-family:Arial'>" + "\n");
            bw.write("<td align='center'>" + testCaseCount + "</td>" + "\n");
            bw.write("<td valign='middle' align='left'>" + className + "</td>");
            bw.write("<td valign='middle' align='left'>" + methodName + "</td>");
            bw.write("<td  valign='middle' align='left'>" + startDateTime + "</td>" + "\n");
            if (response == "PASS") {
                bw.write("<td valign='middle' align='center' style='color:green'>" + response + "</td>");
            } else if (response == "FAIL") {
                bw.write("<td valign='middle' align='center' style='color:red'>" + response + "</td>");
            } else {
                bw.write("<td valign='middle' align='center'>" + response + "</td>");
            }
            bw.write("<td valign='middle' align='center'>" + Exception + "</td>");
            bw.write("</tr>" + "\n");
            bw.write("</body>" + "\n");
            bw.flush();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @AfterSuite(alwaysRun = true)
    public static void createTestCount() {
        try {
            bw.write("<p style='font-size:90%;background-color:#9999ad;font-family:Arial'><b>Total TestCase: "
                    + testCaseCount
                    + " Pass TestCase: " + passTestCase
                    + " Fail TestCase: "
                    + failTestCase + " </p>");

            bw.write("<body>");
            bw.write("</html>");
            bw.flush();
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @BeforeSuite(alwaysRun = true)
    public static void createFile() {
        try {
            File file = new File(resultFile);
            bw = new BufferedWriter(new FileWriter(file, false));
            bw.write(
                    "<h3 align='center' style='background-color:#6082B6;font-family:Arial Black;font-size:120%;'><b> Execution Report</b><h3>");
            bw.write("<table align='center' border='0' width='100%' height='47'>");
            bw.write("<tr style='background-color:#7393B3; font-family:Arial'><b>");
            bw.write("<td  align='center'><b>S.NO</b></td>");
            bw.write("<td  align='left'><b>Class Name</b></td>");
            bw.write("<td  align='left'><b>Test Name</b></td>");
            bw.write("<td  align='left'><b>Start Time</b></td>");
            bw.write("<td  align='center'><b>Status</b></td>");
            bw.write("<td  align='center'><b>Exception</b></td>");
            bw.write("</tr>");
            bw.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
