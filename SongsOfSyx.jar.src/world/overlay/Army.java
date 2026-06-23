/*    */ package world.overlay;
/*    */ 
/*    */ import game.faction.Faction;
/*    */ import game.faction.diplomacy.DIP;
/*    */ import init.sprite.SPRITES;
/*    */ import snake2d.Renderer;
/*    */ import snake2d.SPRITE_RENDERER;
/*    */ import snake2d.util.color.COLOR;
/*    */ import snake2d.util.color.ColorImp;
/*    */ import snake2d.util.datatypes.DIR;
/*    */ import util.colors.GCOLOR;
/*    */ import util.rendering.RenderData;
/*    */ import util.rendering.ShadowBatch;
/*    */ import world.WORLD;
/*    */ import world.map.regions.Region;
/*    */ 
/*    */ class Army
/*    */   extends WorldOverlays.OverlayTile
/*    */ {
/*    */   private Faction army;
/* 21 */   private final COLOR rebel = (COLOR)(new ColorImp((GCOLOR.MAP()).F_REBEL)).shadeSelf(0.3D);
/* 22 */   private final COLOR ally = (COLOR)(new ColorImp((GCOLOR.MAP()).F_ALLY)).shadeSelf(0.3D);
/* 23 */   private final COLOR enemy = (COLOR)(new ColorImp((GCOLOR.MAP()).F_ENEMY)).shadeSelf(0.3D);
/* 24 */   private final COLOR soso = (COLOR)(new ColorImp((GCOLOR.MAP()).SOSO)).shadeSelf(0.3D);
/*    */   Army() {
/* 26 */     super(true, true);
/*    */   }
/*    */ 
/*    */   
/*    */   void add(Faction army) {
/* 31 */     this.army = army;
/* 32 */     add();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected void renderBelow(SPRITE_RENDERER r, ShadowBatch s, RenderData.RenderIterator it) {
/* 38 */     int m = 15;
/*    */     
/* 40 */     if ((WORLD.PATH()).map.is.is(it.tile())) {
/* 41 */       COLOR.WHITE100.bind();
/* 42 */       renderUnder(m, r, it);
/*    */       
/*    */       return;
/*    */     } 
/*    */     
/* 47 */     Region reg = (Region)(WORLD.REGIONS()).map.get(it.tile());
/* 48 */     if (WORLD.REGIONS().border().is(it.tile())) {
/* 49 */       m = 0;
/* 50 */       for (DIR d : DIR.ORTHO) {
/* 51 */         if (!WORLD.IN_BOUNDS(it.tx(), it.ty(), d) || reg == (WORLD.REGIONS()).map.get(it.tx(), it.ty(), d)) {
/* 52 */           m |= d.mask();
/*    */         }
/*    */       } 
/*    */     } 
/*    */     
/* 57 */     COLOR c = this.rebel;
/*    */     
/* 59 */     if (reg != null && reg.faction() != null) {
/* 60 */       if (reg.faction() == this.army) {
/* 61 */         c = this.ally;
/* 62 */       } else if (DIP.WAR().is(this.army, reg.faction())) {
/* 63 */         c = this.enemy;
/*    */       } else {
/* 65 */         c = this.soso;
/*    */       } 
/*    */     }
/* 68 */     c.bind();
/* 69 */     renderUnder(m, r, it);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void renderAbove(Renderer r, ShadowBatch s, RenderData data) {
/* 75 */     (WORLD.OVERLAY()).regNames.renderAbove(r, s, data);
/* 76 */     COLOR.WHITE100.bind();
/* 77 */     super.renderAbove(r, s, data);
/*    */   }
/*    */ 
/*    */   
/*    */   protected void renderAbove(SPRITE_RENDERER r, ShadowBatch s, RenderData.RenderIterator it) {
/* 82 */     if ((WORLD.PATH()).map.is.is(it.tile()) && (WORLD.WATER()).isBig.is(it.tile()))
/* 83 */       (SPRITES.cons()).BIG.line.render(r, 0, it.x(), it.y()); 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\overlay\Army.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */