/*     */ package world.entity.haven;
/*     */ 
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import view.ui.message.MessageSection;
/*     */ import world.WORLD;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class MessChange
/*     */   extends MessageSection
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   private final int ti;
/*     */   private final String desc;
/*     */   
/*     */   public MessChange(WHavenType t, CharSequence title, CharSequence desc) {
/* 189 */     super(title);
/* 190 */     this.ti = t.index();
/* 191 */     this.desc = String.valueOf(desc);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void make(GuiSection section) {
/* 197 */     paragraph(this.desc);
/* 198 */     section.addRelBody(16, DIR.N, (SPRITE)new SPRITE.Imp(64)
/*     */         {
/*     */           public void render(SPRITE_RENDERER r, int X1, int X2, int Y1, int Y2)
/*     */           {
/* 202 */             (((WHavenType)(WORLD.camps()).types.getC(Player.MessChange.this.ti)).race.appearance()).iconBig.render(r, X1, X2, Y1, Y2);
/*     */           }
/*     */         });
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\entity\haven\Player$MessChange.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */