/*     */ package launcher;
/*     */ 
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.file.Json;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class Butt
/*     */   extends GUI.Button
/*     */ {
/*     */   private final String code;
/*     */   private final String name;
/*     */   
/*     */   Butt(String folder, int iconI) {
/*  90 */     super(paramScreenLang.l.res.langs[iconI].scaled(2.0D));
/*     */     
/*  92 */     if (folder == null) {
/*  93 */       this.code = "";
/*  94 */       this.name = "English";
/*     */     } else {
/*  96 */       this.code = folder;
/*  97 */       Json j = new Json(paramScreenLang.plang.getFolder(folder).gets("_Info"));
/*  98 */       this.name = j.text("NAME") + " " + j.text("NAME") + "%";
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean hover(COORDINATE mCoo) {
/* 104 */     if (super.hover(mCoo)) {
/* 105 */       ScreenLang.this.hov = this.name;
/* 106 */       return true;
/*     */     } 
/* 108 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void clickA() {
/* 113 */     if (ScreenLang.this.l.s.lang.get().equals(this.code)) {
/* 114 */       ScreenLang.this.l.setMain();
/*     */     } else {
/* 116 */       ScreenLang.this.l.s.lang.set(this.code);
/* 117 */       ScreenLang.this.l.s.save();
/* 118 */       ScreenLang.this.l.reboot();
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\launcher\ScreenLang$Butt.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */