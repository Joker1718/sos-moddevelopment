/*    */ package view.ui.profile;
/*    */ 
/*    */ import game.faction.FACTIONS;
/*    */ import game.faction.player.PTitles;
/*    */ import init.sprite.UI.UI;
/*    */ import snake2d.SPRITE_RENDERER;
/*    */ import snake2d.util.gui.renderable.RENDEROBJ;
/*    */ import util.gui.misc.GText;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class null
/*    */   extends RENDEROBJ.RenderImp
/*    */ {
/*    */   private final GText text;
/*    */   private final GText tmp;
/*    */   
/*    */   null(int $anonymous0, int $anonymous1) {
/* 53 */     super($anonymous0, $anonymous1);
/*    */     
/* 55 */     this.text = new GText((UI.FONT()).M, 200);
/* 56 */     this.tmp = new GText((UI.FONT()).M, 200);
/*    */   }
/*    */   
/*    */   public void render(SPRITE_RENDERER r, float ds) {
/* 60 */     this.text.clear();
/*    */     
/* 62 */     int y1 = body().y1() + this.text.height() / 2;
/*    */     
/* 64 */     for (PTitles.PTitle t : (FACTIONS.player()).titles.all()) {
/* 65 */       if (t.selected()) {
/* 66 */         this.tmp.set((CharSequence)this.text);
/* 67 */         if (this.text.width() > 0 && this.tmp.width() + this.text.width() > body().width()) {
/* 68 */           this.text.renderC(r, body().cX(), y1);
/* 69 */           this.text.clear();
/* 70 */           this.text.add(t.name);
/* 71 */           this.text.adjustWidth();
/* 72 */           y1 += this.text.height(); continue;
/*    */         } 
/* 74 */         if (this.text.width() > 0)
/* 75 */           this.text.add(',').s(); 
/* 76 */         this.text.add(t.name);
/* 77 */         this.text.adjustWidth();
/*    */       } 
/*    */     } 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 86 */     if (this.text.width() > 0)
/* 87 */       this.text.renderC(r, body().cX(), y1 + this.text.height() / 2); 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\vie\\ui\profile\Level$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */