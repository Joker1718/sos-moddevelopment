/*    */ package view.world.generator;
/*    */ 
/*    */ import game.faction.FACTIONS;
/*    */ import init.race.Race;
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
/*    */   private final GText t;
/*    */   
/*    */   null(int $anonymous0, int $anonymous1) {
/* 66 */     super($anonymous0, $anonymous1);
/*    */     
/* 68 */     this.t = new GText((UI.FONT()).M, 64);
/*    */   }
/*    */   
/*    */   public void render(SPRITE_RENDERER r, float ds) {
/* 72 */     Race rr = FACTIONS.player().race();
/* 73 */     int x = this.body.x1();
/* 74 */     int y = this.body.y1();
/* 75 */     this.t.setMaxWidth(280);
/* 76 */     this.t.setMultipleLines(true); byte b; int i; String[] arrayOfString;
/* 77 */     for (i = (arrayOfString = rr.info.pros).length, b = 0; b < i; ) { String s = arrayOfString[b];
/* 78 */       this.t.clear().add('+').s().add(s).adjustWidth();
/* 79 */       this.t.normalify2();
/* 80 */       this.t.render(r, x + 16, y);
/* 81 */       y += this.t.height(); b++; }
/*    */     
/* 83 */     y = this.body.y1();
/* 84 */     for (i = (arrayOfString = rr.info.cons).length, b = 0; b < i; ) { String s = arrayOfString[b];
/* 85 */       this.t.clear().add('-').s().add(s).adjustWidth();
/* 86 */       this.t.errorify();
/* 87 */       this.t.render(r, x + 325, y);
/* 88 */       y += this.t.height();
/*    */       b++; }
/*    */   
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\world\generator\StagePickRace$3.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */