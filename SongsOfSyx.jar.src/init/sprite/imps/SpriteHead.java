/*    */ package init.sprite.imps;
/*    */ 
/*    */ import game.GAME;
/*    */ import game.time.TIME;
/*    */ import init.race.RACES;
/*    */ import init.race.Race;
/*    */ import init.sprite.SPRITES;
/*    */ import init.sprite.game.Sheet;
/*    */ import init.sprite.game.SheetData;
/*    */ import init.sprite.game.SheetType;
/*    */ import java.io.IOException;
/*    */ import settlement.entity.humanoid.spirte.HSprite;
/*    */ import settlement.main.SETT;
/*    */ import snake2d.CORE;
/*    */ import snake2d.SPRITE_RENDERER;
/*    */ import snake2d.util.file.Json;
/*    */ import snake2d.util.rnd.RND;
/*    */ import snake2d.util.sets.ArrayList;
/*    */ import snake2d.util.sets.LIST;
/*    */ import snake2d.util.sprite.TILE_SHEET;
/*    */ import snake2d.util.sprite.TextureCoords;
/*    */ import util.GUTIL;
/*    */ import util.rendering.RenderData;
/*    */ import util.rendering.ShadowBatch;
/*    */ 
/*    */ class SpriteHead
/*    */   extends Sheet
/*    */ {
/*    */   private final TILE_SHEET spikes;
/*    */   
/*    */   SpriteHead(Json json) throws IOException {
/* 32 */     super(4, true, false);
/* 33 */     SPRITES.GAME().add((SheetType)SheetType.s1x1, (LIST)new ArrayList(this), "SEVERED_HEAD_1X1");
/*    */     
/* 35 */     this.spikes = SPRITES.GAME().raw((SheetType)SheetType.s1x1, "HEAD_SPIKE_1X1", json);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void render(SheetData da, int x, int y, RenderData.RenderIterator it, SPRITE_RENDERER sr, int tile, int random, double degrade) {
/* 44 */     int rot = tile & 0x3;
/* 45 */     this.spikes.render(sr, GUTIL.ran2().get(it.tile()) % this.spikes.tiles() / 4 * 4 + rot, x, y);
/*    */     
/* 47 */     if (!is(it)) {
/*    */       return;
/*    */     }
/* 50 */     Race r = (Race)RACES.all().getC(random & 0xFF);
/*    */     
/* 52 */     if (RND.oneIn(CORE.getGraphics().fps() * 4)) {
/* 53 */       (SETT.THINGS()).gore.bleed(it.tx() * 64 + 32, it.ty() * 64 + 32, 0.0D, 0.0D, (r.appearance()).colors.blood);
/*    */     }
/*    */     
/* 56 */     random >>= 8;
/* 57 */     int gender = random & 0x3;
/* 58 */     random >>= 2;
/*    */     
/* 60 */     HSprite.renderHead(sr, r, gender, rot, random, x, y);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void renderShadow(SheetData da, int x, int y, RenderData.RenderIterator it, ShadowBatch shadow, int tile, int random) {
/* 67 */     int rot = tile & 0x3;
/*    */     
/* 69 */     shadow.setDistance2Ground(0.0D);
/* 70 */     shadow.setHeight(2);
/* 71 */     this.spikes.render((SPRITE_RENDERER)shadow, GUTIL.ran2().get(it.tile()) % this.spikes.tiles() / 4 * 4 + rot, x, y);
/*    */     
/* 73 */     if (!is(it)) {
/*    */       return;
/*    */     }
/* 76 */     shadow.setDistance2Ground(da.shadowHeight);
/* 77 */     shadow.setHeight(da.shadowLength);
/*    */     
/* 79 */     Race r = (Race)RACES.all().getC(random & 0xFF);
/* 80 */     random >>= 8;
/* 81 */     int gender = random & 0x3;
/* 82 */     random >>= 2;
/*    */     
/* 84 */     HSprite.renderHead((SPRITE_RENDERER)shadow, r, gender, tile & 0x3, random, x, y);
/*    */   }
/*    */   
/*    */   private boolean is(RenderData.RenderIterator it) {
/* 88 */     int count = (GAME.count()).EXECUTIONS.current() + 16;
/* 89 */     int r2 = GUTIL.ran2().get(it.tile()) + TIME.days().bitsSinceStart();
/*    */     
/* 91 */     if (count < (r2 & 0xFF))
/* 92 */       return false; 
/* 93 */     return true;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public TextureCoords texture(int tile) {
/* 99 */     return null;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\init\sprite\imps\SpriteHead.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */