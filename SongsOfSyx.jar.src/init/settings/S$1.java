/*     */ package init.settings;
/*     */ 
/*     */ import launcher.LSettings;
/*     */ import snake2d.CORE;
/*     */ import snake2d.util.sets.LISTE;
/*     */ import snake2d.util.sprite.text.Str;
/*     */ import util.text.Dic;
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
/*     */ class null
/*     */   extends S.Setting
/*     */ {
/*     */   null(LISTE<S.Setting> $anonymous0, LSettings.LSettingInt $anonymous1, CharSequence $anonymous2, CharSequence $anonymous3) {
/*  90 */     super($anonymous0, $anonymous1, $anonymous2, $anonymous3);
/*     */   }
/*     */   
/*     */   public int max() {
/*  94 */     return 1;
/*     */   }
/*     */ 
/*     */   
/*     */   public int min() {
/*  99 */     return 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public void getValue(Str str) {
/* 104 */     str.clear().add((get() == 0) ? Dic.¤¤off : Dic.¤¤on);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void set(int t) {
/* 110 */     super.set(t);
/* 111 */     CORE.getSoundCore().setMuteOnFocus((t == 1));
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\init\settings\S$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */