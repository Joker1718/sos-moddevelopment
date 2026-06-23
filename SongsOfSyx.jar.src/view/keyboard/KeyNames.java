/*    */ package view.keyboard;
/*    */ 
/*    */ import java.util.Iterator;
/*    */ import snake2d.CORE;
/*    */ import snake2d.KEYCODES;
/*    */ import snake2d.LOG;
/*    */ import snake2d.util.sprite.text.Str;
/*    */ import util.text.D;
/*    */ 
/*    */ class KeyNames {
/*    */   private final CharSequence[] names;
/* 12 */   private static CharSequence ¤¤none = "---";
/* 13 */   private static CharSequence ¤¤unknown = "???";
/*    */   
/*    */   KeyNames() {
/* 16 */     D.t(this);
/*    */     
/* 18 */     this.names = new CharSequence[KEYCODES.lastCode() + 1];
/*    */     
/* 20 */     for (Iterator<Integer> iterator1 = KEYCODES.all.iterator(); iterator1.hasNext(); ) { int j = ((Integer)iterator1.next()).intValue();
/* 21 */       this.names[j] = CORE.getInput().getKeyboard().translate(j); }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 27 */     this.names[32] = D.g("space");
/* 28 */     this.names[256] = D.g("escape");
/* 29 */     this.names[280] = D.g("caps-lock");
/* 30 */     this.names[281] = D.g("scroll-lock");
/* 31 */     this.names[282] = D.g("num-lock");
/* 32 */     this.names[284] = D.g("pause");
/* 33 */     this.names[257] = D.g("enter");
/* 34 */     this.names[258] = D.g("tab");
/* 35 */     this.names[259] = D.g("backspace");
/* 36 */     this.names[260] = D.g("insert");
/* 37 */     this.names[261] = D.g("delete");
/* 38 */     this.names[262] = D.g("right");
/* 39 */     this.names[263] = D.g("left");
/* 40 */     this.names[264] = D.g("down");
/* 41 */     this.names[265] = D.g("up");
/* 42 */     this.names[266] = D.g("page-up");
/* 43 */     this.names[267] = D.g("page-down");
/* 44 */     this.names[268] = D.g("home");
/* 45 */     this.names[269] = D.g("end");
/* 46 */     this.names[283] = D.g("print-screen");
/* 47 */     this.names[340] = D.g("left-shift");
/* 48 */     this.names[341] = D.g("left-ctrl");
/* 49 */     this.names[344] = D.g("right-shift");
/* 50 */     this.names[345] = D.g("right-ctrl");
/* 51 */     this.names[335] = D.g("pad-enter");
/* 52 */     this.names[336] = D.g("pad-equals");
/* 53 */     this.names[342] = D.g("left-alt");
/* 54 */     this.names[343] = D.g("left-super");
/* 55 */     this.names[348] = D.g("menu");
/* 56 */     this.names[346] = D.g("right-alt");
/* 57 */     this.names[347] = D.g("right-super");
/*    */ 
/*    */     
/* 60 */     CharSequence ff = D.g("F", "F{0}"); int i;
/* 61 */     for (i = 290; i <= 314; i++) {
/* 62 */       int k = i - 290 + 1;
/* 63 */       this.names[i] = String.valueOf((new Str(ff)).insert(0, k));
/*    */     } 
/*    */     
/* 66 */     for (Iterator<Integer> iterator2 = KEYCODES.all.iterator(); iterator2.hasNext(); ) { i = ((Integer)iterator2.next()).intValue();
/* 67 */       if (this.names[i] == null || this.names[i].length() == 0) {
/* 68 */         LOG.ln(Integer.valueOf(i));
/*    */       } }
/*    */   
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public CharSequence getCode(int code) {
/* 77 */     if (code < 0) {
/* 78 */       return ¤¤none;
/*    */     }
/* 80 */     if (code >= this.names.length || this.names[code] == null) {
/* 81 */       return ¤¤unknown;
/*    */     }
/* 83 */     return this.names[code];
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\keyboard\KeyNames.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */