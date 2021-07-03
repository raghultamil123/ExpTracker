import { UserEmail } from "./user-email.model";
import { UserPhone } from "./user-phone.model";

export class User{
    public userId:string;
    public firstName:string;
    public lastName:string;
    public dateOfBirth:string;
    public userEmail?:UserEmail[];
    public mobile?:UserPhone[];
}