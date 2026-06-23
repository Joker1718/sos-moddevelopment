/*     */ package snake2d;
/*     */ 
/*     */ import java.lang.reflect.Field;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sets.Bitmap1D;
/*     */ import snake2d.util.sets.LIST;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class KEYCODES
/*     */ {
/*     */   public static final int KEY_SPACE = 32;
/*     */   public static final int KEY_APOSTROPHE = 39;
/*     */   public static final int KEY_COMMA = 44;
/*     */   public static final int KEY_MINUS = 45;
/*     */   public static final int KEY_PERIOD = 46;
/*     */   public static final int KEY_SLASH = 47;
/*     */   public static final int KEY_0 = 48;
/*     */   public static final int KEY_1 = 49;
/*     */   public static final int KEY_2 = 50;
/*     */   public static final int KEY_3 = 51;
/*     */   public static final int KEY_4 = 52;
/*     */   public static final int KEY_5 = 53;
/*     */   public static final int KEY_6 = 54;
/*     */   public static final int KEY_7 = 55;
/*     */   public static final int KEY_8 = 56;
/*     */   public static final int KEY_9 = 57;
/*  49 */   public static final int[] KEY_NUMS = new int[] {
/*  50 */       48, 49, 50, 51, 52, 53, 54, 55, 56, 57
/*     */     };
/*     */ 
/*     */   
/*     */   public static final int KEY_SEMICOLON = 59;
/*     */   
/*     */   public static final int KEY_EQUAL = 61;
/*     */   
/*     */   public static final int KEY_A = 65;
/*     */   
/*     */   public static final int KEY_B = 66;
/*     */   
/*     */   public static final int KEY_C = 67;
/*     */   
/*     */   public static final int KEY_D = 68;
/*     */   
/*     */   public static final int KEY_E = 69;
/*     */   
/*     */   public static final int KEY_F = 70;
/*     */   
/*     */   public static final int KEY_G = 71;
/*     */   
/*     */   public static final int KEY_H = 72;
/*     */   
/*     */   public static final int KEY_I = 73;
/*     */   
/*     */   public static final int KEY_J = 74;
/*     */   
/*     */   public static final int KEY_K = 75;
/*     */   
/*     */   public static final int KEY_L = 76;
/*     */   
/*     */   public static final int KEY_M = 77;
/*     */   
/*     */   public static final int KEY_N = 78;
/*     */   
/*     */   public static final int KEY_O = 79;
/*     */   
/*     */   public static final int KEY_P = 80;
/*     */   
/*     */   public static final int KEY_Q = 81;
/*     */   
/*     */   public static final int KEY_R = 82;
/*     */   
/*     */   public static final int KEY_S = 83;
/*     */   
/*     */   public static final int KEY_T = 84;
/*     */   
/*     */   public static final int KEY_U = 85;
/*     */   
/*     */   public static final int KEY_V = 86;
/*     */   
/*     */   public static final int KEY_W = 87;
/*     */   
/*     */   public static final int KEY_X = 88;
/*     */   
/*     */   public static final int KEY_Y = 89;
/*     */   
/*     */   public static final int KEY_Z = 90;
/*     */   
/*     */   public static final int KEY_LEFT_BRACKET = 91;
/*     */   
/*     */   public static final int KEY_BACKSLASH = 92;
/*     */   
/*     */   public static final int KEY_RIGHT_BRACKET = 93;
/*     */   
/*     */   public static final int KEY_GRAVE_ACCENT = 96;
/*     */   
/*     */   public static final int KEY_WORLD_2 = 162;
/*     */   
/*     */   public static final int KEY_ESCAPE = 256;
/*     */   
/*     */   public static final int KEY_ENTER = 257;
/*     */   
/*     */   public static final int KEY_TAB = 258;
/*     */   
/*     */   public static final int KEY_BACKSPACE = 259;
/*     */   
/*     */   public static final int KEY_INSERT = 260;
/*     */   
/*     */   public static final int KEY_DELETE = 261;
/*     */   
/*     */   public static final int KEY_RIGHT = 262;
/*     */   
/*     */   public static final int KEY_LEFT = 263;
/*     */   
/*     */   public static final int KEY_DOWN = 264;
/*     */   
/*     */   public static final int KEY_UP = 265;
/*     */   
/*     */   public static final int KEY_PAGE_UP = 266;
/*     */   
/*     */   public static final int KEY_PAGE_DOWN = 267;
/*     */   
/*     */   public static final int KEY_HOME = 268;
/*     */   
/*     */   public static final int KEY_END = 269;
/*     */   
/*     */   public static final int KEY_CAPS_LOCK = 280;
/*     */   
/*     */   public static final int KEY_SCROLL_LOCK = 281;
/*     */   
/*     */   public static final int KEY_NUM_LOCK = 282;
/*     */   
/*     */   public static final int KEY_PRINT_SCREEN = 283;
/*     */   
/*     */   public static final int KEY_PAUSE = 284;
/*     */   
/*     */   public static final int KEY_F1 = 290;
/*     */   
/*     */   public static final int KEY_F2 = 291;
/*     */   
/*     */   public static final int KEY_F3 = 292;
/*     */   
/*     */   public static final int KEY_F4 = 293;
/*     */   
/*     */   public static final int KEY_F5 = 294;
/*     */   
/*     */   public static final int KEY_F6 = 295;
/*     */   
/*     */   public static final int KEY_F7 = 296;
/*     */   
/*     */   public static final int KEY_F8 = 297;
/*     */   
/*     */   public static final int KEY_F9 = 298;
/*     */   
/*     */   public static final int KEY_F10 = 299;
/*     */   
/*     */   public static final int KEY_F11 = 300;
/*     */   
/*     */   public static final int KEY_F12 = 301;
/*     */   
/*     */   public static final int KEY_F13 = 302;
/*     */   
/*     */   public static final int KEY_F14 = 303;
/*     */   
/*     */   public static final int KEY_F15 = 304;
/*     */   
/*     */   public static final int KEY_F16 = 305;
/*     */   
/*     */   public static final int KEY_F17 = 306;
/*     */   
/*     */   public static final int KEY_F18 = 307;
/*     */   
/*     */   public static final int KEY_F19 = 308;
/*     */   
/*     */   public static final int KEY_F20 = 309;
/*     */   
/*     */   public static final int KEY_F21 = 310;
/*     */   
/*     */   public static final int KEY_F22 = 311;
/*     */   
/*     */   public static final int KEY_F23 = 312;
/*     */   
/*     */   public static final int KEY_F24 = 313;
/*     */   
/*     */   public static final int KEY_F25 = 314;
/*     */   
/*     */   public static final int KEY_KP_0 = 320;
/*     */   
/*     */   public static final int KEY_KP_1 = 321;
/*     */   
/*     */   public static final int KEY_KP_2 = 322;
/*     */   
/*     */   public static final int KEY_KP_3 = 323;
/*     */   
/*     */   public static final int KEY_KP_4 = 324;
/*     */   
/*     */   public static final int KEY_KP_5 = 325;
/*     */   
/*     */   public static final int KEY_KP_6 = 326;
/*     */   
/*     */   public static final int KEY_KP_7 = 327;
/*     */   
/*     */   public static final int KEY_KP_8 = 328;
/*     */   
/*     */   public static final int KEY_KP_9 = 329;
/*     */   
/*     */   public static final int KEY_KP_DECIMAL = 330;
/*     */   
/*     */   public static final int KEY_KP_DIVIDE = 331;
/*     */   
/*     */   public static final int KEY_KP_MULTIPLY = 332;
/*     */   
/*     */   public static final int KEY_KP_SUBTRACT = 333;
/*     */   
/*     */   public static final int KEY_KP_ADD = 334;
/*     */   
/*     */   public static final int KEY_KP_ENTER = 335;
/*     */   
/*     */   public static final int KEY_KP_EQUAL = 336;
/*     */   
/*     */   public static final int KEY_LEFT_SHIFT = 340;
/*     */   
/*     */   public static final int KEY_LEFT_CONTROL = 341;
/*     */   
/*     */   public static final int KEY_LEFT_ALT = 342;
/*     */   
/*     */   public static final int KEY_LEFT_SUPER = 343;
/*     */   
/*     */   public static final int KEY_RIGHT_SHIFT = 344;
/*     */   
/*     */   public static final int KEY_RIGHT_CONTROL = 345;
/*     */   
/*     */   public static final int KEY_RIGHT_ALT = 346;
/*     */   
/*     */   public static final int KEY_RIGHT_SUPER = 347;
/*     */   
/*     */   public static final int KEY_MENU = 348;
/*     */   
/*     */   public static final LIST<Integer> all;
/*     */ 
/*     */   
/*     */   public static int lastCode() {
/* 264 */     return 348;
/*     */   }
/*     */   
/*     */   static {
/* 268 */     int am = 0; byte b; int i; Field[] arrayOfField1;
/* 269 */     for (i = (arrayOfField1 = KEYCODES.class.getDeclaredFields()).length, b = 0; b < i; ) { Field f = arrayOfField1[b];
/*     */       
/* 271 */       if (int.class == f.getType()) {
/* 272 */         am++;
/*     */       }
/*     */       b++; }
/*     */     
/* 276 */     ArrayList<Integer> alll = new ArrayList(am);
/* 277 */   } private static final Bitmap1D exists = new Bitmap1D(lastCode(), false);
/*     */   static {
/* 279 */     am = 0; Field[] arrayOfField2;
/* 280 */     for (int j = (arrayOfField2 = KEYCODES.class.getDeclaredFields()).length; i < j; ) { Field f = arrayOfField2[i];
/* 281 */       if (int.class == f.getType()) {
/*     */         
/*     */         try {
/* 284 */           int value = f.getInt(null);
/* 285 */           alll.add(Integer.valueOf(value));
/* 286 */           exists.set(value, true);
/*     */         }
/* 288 */         catch (IllegalArgumentException e) {
/*     */           
/* 290 */           e.printStackTrace();
/* 291 */         } catch (IllegalAccessException e) {
/*     */           
/* 293 */           e.printStackTrace();
/*     */         } 
/*     */       }
/*     */       
/*     */       i++; }
/*     */     
/* 299 */     all = (LIST<Integer>)alll;
/*     */   }
/*     */ 
/*     */   
/*     */   public static boolean exists(int code) {
/* 304 */     return exists.get(code);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\snake2d\KEYCODES.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */