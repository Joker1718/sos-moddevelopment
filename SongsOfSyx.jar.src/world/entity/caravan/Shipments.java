/*    */ package world.entity.caravan;
/*    */ 
/*    */ import init.paths.PATHS;
/*    */ import init.trade.TRADE_TYPE;
/*    */ import java.io.IOException;
/*    */ import java.nio.file.Path;
/*    */ import snake2d.SPRITE_RENDERER;
/*    */ import snake2d.util.color.COLOR;
/*    */ import snake2d.util.datatypes.COORDINATE;
/*    */ import snake2d.util.datatypes.DIR;
/*    */ import snake2d.util.sets.LISTE;
/*    */ import snake2d.util.sets.Stack;
/*    */ import snake2d.util.sprite.SPRITE;
/*    */ import snake2d.util.sprite.TILE_SHEET;
/*    */ import util.spritecomposer.ComposerDests;
/*    */ import util.spritecomposer.ComposerSources;
/*    */ import util.spritecomposer.ComposerThings;
/*    */ import util.spritecomposer.ComposerUtil;
/*    */ import view.main.VIEW;
/*    */ import world.WORLD;
/*    */ import world.entity.WEntity;
/*    */ import world.entity.WEntityConstructor;
/*    */ import world.map.regions.Region;
/*    */ 
/*    */ public final class Shipments
/*    */   extends WEntityConstructor<Shipment> {
/* 27 */   final Stack<Shipment> free = new Stack(1024);
/*    */   public final SPRITE icon;
/*    */   
/* 30 */   final TILE_SHEET caravan = (new ComposerThings.ITileSheet(PATHS.SPRITE().getFolder("world").getFolder("entity").get("Tribute"), 100, 224)
/*    */     {
/*    */       protected TILE_SHEET init(ComposerUtil c, ComposerSources s, ComposerDests d)
/*    */       {
/* 34 */         s.singles.init(0, 0, 1, 12, 2, 1, (ComposerDests.Dest)d.s16);
/* 35 */         for (int i = 0; i < 12; i++) {
/* 36 */           s.singles.setVar(i);
/* 37 */           s.singles.paste(3, true);
/*    */         } 
/*    */         
/* 40 */         return d.s16.saveGame();
/*    */       }
/* 43 */     }).get();
/*    */   
/*    */   public Shipments(LISTE<WEntityConstructor<?>> tot) throws IOException {
/* 46 */     super(tot, true);
/* 47 */     this.icon = (SPRITE)new SPRITE.Imp(32, 32)
/*    */       {
/*    */         public void render(SPRITE_RENDERER r, int X1, int X2, int Y1, int Y2)
/*    */         {
/* 51 */           int i = (int)(VIEW.renderSecond() * 2.0D) % 3;
/* 52 */           i *= 8;
/* 53 */           i += 32;
/* 54 */           COLOR.WHITE150.bind();
/* 55 */           (WORLD.ENTITIES()).caravans.caravan.render(r, i + DIR.SE.id(), X1, X2, Y1, Y2);
/* 56 */           COLOR.unbind();
/*    */         }
/*    */       };
/*    */   }
/*    */ 
/*    */   
/*    */   public Shipment create(Region start, Region dest, TRADE_TYPE type) {
/* 63 */     COORDINATE cc = WORLD.PATH().rnd(start);
/*    */     
/* 65 */     if (cc != null) {
/* 66 */       return create(cc.x(), cc.y(), dest, type);
/*    */     }
/* 68 */     return null;
/*    */   }
/*    */   
/*    */   public Shipment create(int sx, int sy, Region dest, TRADE_TYPE type) {
/* 72 */     Shipment c = create();
/* 73 */     c.add(sx, sy, dest.faction(), type);
/* 74 */     if (c.added()) {
/* 75 */       return c;
/*    */     }
/* 77 */     this.free.push(c);
/* 78 */     return null;
/*    */   }
/*    */ 
/*    */   
/*    */   protected Shipment create() {
/* 83 */     if (!this.free.isEmpty()) {
/* 84 */       return (Shipment)this.free.pop();
/*    */     }
/* 86 */     return new Shipment();
/*    */   }
/*    */   
/*    */   protected void clear() {}
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\entity\caravan\Shipments.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */