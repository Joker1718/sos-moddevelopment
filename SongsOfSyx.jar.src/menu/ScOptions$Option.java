/*     */ package menu;
/*     */ 
/*     */ import init.settings.S;
/*     */ import snake2d.util.sprite.text.Str;
/*     */ import util.data.INT;
/*     */ import util.gui.misc.GText;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class Option
/*     */   extends GUI.OptionLine
/*     */ {
/*     */   private final S.Setting sett;
/*     */   
/*     */   protected Option(S.Setting s) {
/*  96 */     super((INT.INTE)s, s.name);
/*  97 */     this.sett = s;
/*  98 */     paramScOptions.options.add(this);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void setValue(GText str) {
/* 103 */     this.sett.getValue((Str)str);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean click() {
/* 108 */     if (super.click()) {
/* 109 */       S.get().applyRuntimeConfigs();
/* 110 */       return true;
/*     */     } 
/* 112 */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\menu\ScOptions$Option.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */