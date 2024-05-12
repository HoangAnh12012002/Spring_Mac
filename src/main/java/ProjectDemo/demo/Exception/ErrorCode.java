package ProjectDemo.demo.Exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

//dinh nghia code
//gom code va mess
//gio , can tra ve 1 exception nao thi chi can throw AppException vowis message dc dinh nghia trong ErrorCode

@Getter
public enum ErrorCode {
    UNCATEGORIZED_EXCEPTION(9999,"UNCATEGORIZED ERROR", HttpStatus.INTERNAL_SERVER_ERROR), //day la loai exception khong ngo toi
    USER_EXISTED(1001,"User existed",HttpStatus.BAD_REQUEST),
    INVALID_NAME_FORMAT(1002,"WRONG NAME FORMAT",HttpStatus.BAD_REQUEST),
    NOT_MATCH_PASS(1003,"PASS not match",HttpStatus.BAD_REQUEST),
    UNAUTHENTICATED(1004,"Unauthenticated",HttpStatus.UNAUTHORIZED),
    UNAUTHORIZED(1005,"you do not have permission",HttpStatus.FORBIDDEN),
    WRONG_PASS_OR_EMAIL(1006,"invalid password or gmail",HttpStatus.BAD_REQUEST),
    //404 la NOTFOUND , vi du nhu tim user nhung ko ton tai


    INVALID_KEY(1007,"Invalid message key",HttpStatus.BAD_REQUEST), //dinh nghĩa 1 số cái nhập sai ở dto, ví dụ như PAS_INVALID mà thiếu chữ S
    USERNAME_INVALID(1008,"USERNAME must be at least 3 chracter",HttpStatus.BAD_REQUEST),
    PASS_INVALID(1009,"Password must be at least 4 chracter",HttpStatus.BAD_REQUEST) //bỏ vào userdto thay cho lúc trước
    ;

    ErrorCode(int code, String message,HttpStatusCode statusCode) {
        this.code = code;
        this.message = message;
        this.statusCode=statusCode;
    }

    private int code;
    private String message;
    private HttpStatusCode statusCode;

}
