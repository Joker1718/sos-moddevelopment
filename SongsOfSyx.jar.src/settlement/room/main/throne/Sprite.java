/*     */ package settlement.room.main.throne;
/*     */ 
/*     */ import game.GAME;
/*     */ import init.sprite.UI.Icon;
/*     */ import init.sprite.UI.UI;
/*     */ import java.io.IOException;
/*     */ import java.nio.file.Path;
/*     */ import settlement.main.SETT;
/*     */ import settlement.room.main.util.RoomInitData;
/*     */ import settlement.room.sprite.RoomSprite;
/*     */ import settlement.room.sprite.RoomSprite1x1;
/*     */ import snake2d.Renderer;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.color.ColorImp;
/*     */ import snake2d.util.file.Json;
/*     */ import snake2d.util.sprite.TILE_SHEET;
/*     */ import util.rendering.RenderData;
/*     */ import util.rendering.ShadowBatch;
/*     */ import util.spritecomposer.ComposerDests;
/*     */ import util.spritecomposer.ComposerSources;
/*     */ import util.spritecomposer.ComposerThings;
/*     */ import util.spritecomposer.ComposerUtil;
/*     */ 
/*     */ 
/*     */ final class Sprite
/*     */ {
/*     */   final COLOR miniC;
/*     */   public final Icon icon;
/*     */   private final TILE_SHEET sfloor;
/*     */   private final TILE_SHEET sthrone;
/*     */   static final int WIDTH = 5;
/*     */   static final int HEIGHT = 3;
/*     */   private final RoomSprite candle;
/*  35 */   private int shadow = 20;
/*     */ 
/*     */   
/*     */   Sprite(RoomInitData init) throws IOException {
/*  39 */     this.miniC = (COLOR)new ColorImp(init.data(), "MINI_COLOR");
/*  40 */     this.icon = UI.icons().get(init.data());
/*     */     
/*  42 */     Json sp = init.data().json("SPRITES");
/*     */     
/*  44 */     this.candle = (RoomSprite)new RoomSprite1x1(sp, "TORCH_1X1");
/*     */     
/*  46 */     this.sfloor = (new ComposerThings.ITileSheet(init.sp(), 264, 240)
/*     */       {
/*     */         protected TILE_SHEET init(ComposerUtil c, ComposerSources s, ComposerDests d)
/*     */         {
/*  50 */           s.full.init(0, 0, 1, 4, 3, 3, d.s16);
/*  51 */           s.full.paste(true);
/*  52 */           s.full.setVar(1).paste(true);
/*  53 */           s.full.setVar(2).paste(true);
/*  54 */           s.full.setVar(3).paste(true);
/*  55 */           return d.s16.saveGame();
/*     */         }
/*  57 */       }).get();
/*     */     
/*  59 */     this.sthrone = (new ComposerThings.ITileSheet()
/*     */       {
/*     */         protected TILE_SHEET init(ComposerUtil c, ComposerSources s, ComposerDests d)
/*     */         {
/*  63 */           s.singles.init(s.full.body().x2(), s.full.body().y1(), 1, 5, 1, 1, (ComposerDests.Dest)d.s24);
/*  64 */           s.singles.setVar(0).paste(3, true);
/*  65 */           s.singles.setVar(1).paste(3, true);
/*  66 */           s.singles.setVar(2).paste(3, true);
/*  67 */           s.singles.setVar(3).paste(3, true);
/*  68 */           s.singles.setVar(4).paste(3, true);
/*  69 */           s.singles.init(s.singles.body().x2(), s.singles.body().y1(), 1, 5, 1, 1, (ComposerDests.Dest)d.s24);
/*  70 */           s.singles.setVar(0).paste(3, true);
/*  71 */           s.singles.setVar(1).paste(3, true);
/*  72 */           s.singles.setVar(2).paste(3, true);
/*  73 */           s.singles.setVar(3).paste(3, true);
/*  74 */           s.singles.setVar(4).paste(3, true);
/*     */           
/*  76 */           return d.s24.saveGame();
/*     */         }
/*  78 */       }).get();
/*     */   }
/*     */ 
/*     */   
/*     */   static int width(int rot) {
/*  83 */     return ((rot & 0x1) == 0) ? 5 : 3;
/*     */   }
/*     */   
/*     */   static int height(int rot) {
/*  87 */     return ((rot & 0x1) == 1) ? 5 : 3;
/*     */   }
/*     */   
/*     */   void renderFloor(Renderer r, ShadowBatch shadowBatch, RenderData.RenderIterator it) {
/*  91 */     double t = GAME.player().level().current().index();
/*  92 */     t /= GAME.player().level().all().size();
/*  93 */     t *= 3.0D;
/*  94 */     int d = (SETT.ROOMS()).data.get(it.tile()) & 0xF;
/*  95 */     d += (int)t * 9;
/*  96 */     this.sfloor.render((SPRITE_RENDERER)r, d, it.x(), it.y());
/*     */   }
/*     */ 
/*     */   
/*     */   void renderThrone(Renderer r, ShadowBatch shadowBatch, RenderData.RenderIterator it, int rot) {
/* 101 */     double t = GAME.player().level().current().index();
/* 102 */     t /= GAME.player().level().all().size();
/* 103 */     t *= 5.0D;
/*     */     
/* 105 */     int x = it.x() - 16;
/* 106 */     int y = it.y() - 16;
/* 107 */     int tile = rot;
/* 108 */     tile += (int)t * 4;
/*     */     
/* 110 */     this.sthrone.render((SPRITE_RENDERER)r, tile, x, y);
/* 111 */     shadowBatch.setDistance2Ground(0.0D).setHeight(12);
/* 112 */     this.sthrone.render((SPRITE_RENDERER)shadowBatch, this.shadow + tile, x, y);
/*     */   }
/*     */ 
/*     */   
/*     */   void renderTorch(Renderer r, ShadowBatch shadowBatch, RenderData.RenderIterator it, int rot) {
/* 117 */     this.candle.render((SPRITE_RENDERER)r, shadowBatch, 0, it, 0.0D, true);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\main\throne\Sprite.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */