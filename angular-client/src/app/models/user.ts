import {Principal} from "./principal";
import {Authority} from "./authority";

export class User {
  details: Object;
  authorities: Authority[];
  authenticated: boolean;
  principal: Principal;
  credentials: Object;
  name: string;

}
