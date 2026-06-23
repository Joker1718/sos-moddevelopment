/*     */ package launcher;
/*     */ 
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.SoundDevices;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import snake2d.util.sprite.text.Text;
/*     */ import util.text.D;
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
/*     */   extends SPRITE.Imp
/*     */ {
/*     */   Text t;
/*     */   CharSequence a;
/*     */   
/*     */   null(int $anonymous0, int $anonymous1) {
/* 121 */     super($anonymous0, $anonymous1);
/* 122 */     this.t = new Text(paramLauncher.res.font, 64);
/* 123 */     this.a = D.g("Audio");
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void render(SPRITE_RENDERER r, int X1, int X2, int Y1, int Y2) {
/* 129 */     this.t.clear().add(this.a).add(':').s();
/* 130 */     this.t.add(get());
/* 131 */     this.t.setMaxWidth(250);
/* 132 */     this.t.setMultipleLines(false);
/* 133 */     this.t.adjustWidth();
/* 134 */     this.t.renderC(r, X1 + (X2 - X1) / 2, Y1 + (Y2 - Y1) / 2);
/*     */   }
/*     */   
/*     */   private CharSequence get() {
/* 138 */     String a = l.s.audiodevice.get();
/* 139 */     if (a == null)
/* 140 */       return none; 
/* 141 */     if (a.isEmpty()) {
/* 142 */       return def;
/*     */     }
/* 144 */     for (String s : SoundDevices.get()) {
/* 145 */       if (s.equalsIgnoreCase(a)) {
/* 146 */         return s;
/*     */       }
/*     */     } 
/*     */     
/* 150 */     if (SoundDevices.get().size() > 0) {
/* 151 */       return (CharSequence)SoundDevices.get().get(0);
/*     */     }
/* 153 */     return none;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\launcher\ScreenSetting$4.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */