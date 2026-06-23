/*     */ package world.entity.haven;
/*     */ 
/*     */ import game.faction.FACTIONS;
/*     */ import init.sprite.UI.UI;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.gui.misc.GButt;
/*     */ import view.main.VIEW;
/*     */ import view.ui.message.MessageSection;
/*     */ import world.WORLD;
/*     */ import world.entity.WEntity;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class MessOwn
/*     */   extends MessageSection
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   final int tx;
/*     */   final int ty;
/*     */   
/*     */   public MessOwn() {
/* 144 */     super(Player.¤¤titleNew);
/* 145 */     WHaven f = first();
/* 146 */     this.tx = f.ctx();
/* 147 */     this.ty = f.cty();
/*     */   }
/*     */   
/*     */   private WHaven first() {
/* 151 */     for (WEntity e : WORLD.ENTITIES().allSlow()) {
/* 152 */       if (e.faction() == FACTIONS.player() && e instanceof WHaven) {
/* 153 */         return (WHaven)e;
/*     */       }
/*     */     } 
/* 156 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void make(GuiSection section) {
/* 161 */     paragraph(Player.¤¤bodyNew);
/*     */     
/* 163 */     section.addRelBody(16, DIR.S, (RENDEROBJ)new GButt.ButtPanel((SPRITE)(UI.icons()).m.crossair)
/*     */         {
/*     */           protected void clickA()
/*     */           {
/* 167 */             VIEW.world().activate();
/* 168 */             (VIEW.world()).window.setZoomout(0);
/* 169 */             (VIEW.world()).window.centererTile.set(Player.MessOwn.this.tx, Player.MessOwn.this.ty);
/*     */           }
/*     */         });
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\entity\haven\Player$MessOwn.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */