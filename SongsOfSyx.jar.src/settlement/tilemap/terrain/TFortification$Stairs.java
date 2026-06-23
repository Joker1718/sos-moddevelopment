/*     */ package settlement.tilemap.terrain;
/*     */ 
/*     */ import game.audio.AUDIO;
/*     */ import game.audio.SoundRace;
/*     */ import init.paths.PATH;
/*     */ import init.paths.PATHS;
/*     */ import init.resources.RESOURCE;
/*     */ import java.io.IOException;
/*     */ import java.nio.file.Path;
/*     */ import settlement.path.AVAILABILITY;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import snake2d.util.sprite.TILE_SHEET;
/*     */ import util.rendering.RenderData;
/*     */ import util.rendering.ShadowBatch;
/*     */ import util.spritecomposer.ComposerDests;
/*     */ import util.spritecomposer.ComposerSources;
/*     */ import util.spritecomposer.ComposerThings;
/*     */ import util.spritecomposer.ComposerUtil;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class Stairs
/*     */   extends Terrain.TerrainTile
/*     */ {
/*     */   private final TILE_SHEET stairC;
/*     */   private final TILE_SHEET stairEdge;
/*     */   TerrainClearing clear;
/*     */   
/*     */   static Stairs make(Terrain t) throws IOException {
/* 635 */     PATH gSprite = PATHS.SPRITE_SETTLEMENT().getFolder("fortification");
/*     */ 
/*     */     
/* 638 */     final TILE_SHEET stairC = (new ComposerThings.ITileSheet(gSprite.get("_Stairs"), 216, 28)
/*     */       {
/*     */         protected TILE_SHEET init(ComposerUtil c, ComposerSources s, ComposerDests d)
/*     */         {
/* 642 */           s.full.init(0, 0, 1, 1, 6, 1, d.s16);
/* 643 */           s.full.setSkip(4, 1);
/* 644 */           s.full.paste(3, true);
/* 645 */           return d.s16.saveGame();
/*     */         }
/* 647 */       }).get();
/*     */     
/* 649 */     final TILE_SHEET stairEdge = (new ComposerThings.ITileSheet()
/*     */       {
/*     */ 
/*     */ 
/*     */         
/*     */         protected TILE_SHEET init(ComposerUtil c, ComposerSources s, ComposerDests d)
/*     */         {
/* 656 */           s.full.setSkip(1, 5).pasteRotated(0, true);
/* 657 */           s.full.setSkip(1, 0).pasteRotated(0, true);
/*     */ 
/*     */           
/* 660 */           s.full.setSkip(1, 5).pasteRotated(1, true);
/* 661 */           s.full.setSkip(1, 0).pasteRotated(1, true);
/*     */ 
/*     */ 
/*     */           
/* 665 */           s.full.setSkip(1, 5).pasteRotated(2, true);
/* 666 */           s.full.setSkip(1, 0).pasteRotated(2, true);
/*     */ 
/*     */           
/* 669 */           s.full.setSkip(1, 5).pasteRotated(3, true);
/* 670 */           s.full.setSkip(1, 0).pasteRotated(3, true);
/*     */ 
/*     */           
/* 673 */           return d.s16.saveGame();
/*     */         }
/* 675 */       }).get();
/*     */     
/* 677 */     SPRITE.Imp imp = new SPRITE.Imp(32)
/*     */       {
/*     */         public void render(SPRITE_RENDERER r, int X1, int X2, int Y1, int Y2)
/*     */         {
/* 681 */           stairC.render(r, 8, X1, X1 + 16, Y1, Y1 + 16);
/* 682 */           stairC.render(r, 8, X1 + 16, X1 + 32, Y1, Y1 + 16);
/* 683 */           stairC.render(r, 0, X1, X1 + 16, Y1 + 16, Y1 + 32);
/* 684 */           stairC.render(r, 0, X1 + 16, X1 + 32, Y1 + 16, Y1 + 32);
/* 685 */           stairEdge.render(r, 5, X1, X1 + 16, Y1, Y1 + 16);
/* 686 */           stairEdge.render(r, 4, X1 + 16, X1 + 32, Y1, Y1 + 16);
/* 687 */           stairEdge.render(r, 0, X1, X1 + 16, Y1 + 16, Y1 + 32);
/* 688 */           stairEdge.render(r, 1, X1 + 16, X1 + 32, Y1 + 16, Y1 + 32);
/*     */         }
/*     */       };
/*     */ 
/*     */     
/* 693 */     return new Stairs(t, stairC, stairEdge, (SPRITE)imp);
/*     */   }
/*     */   
/*     */   private Stairs(Terrain t, TILE_SHEET stairC, TILE_SHEET stairEdge, SPRITE icon) throws IOException
/*     */   {
/* 698 */     super("STAIRS", t, TFortification.¤¤stairs, icon, (COLOR)null);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 769 */     this.clear = new TerrainClearing()
/*     */       {
/* 771 */         private final SoundRace sound = AUDIO.race("CLEAR_STAIRS");
/*     */ 
/*     */         
/*     */         public RESOURCE clear1(int tx, int ty) {
/* 775 */           TFortification.Stairs.this.shared.NADA.placeFixed(tx, ty);
/* 776 */           return null;
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean can() {
/* 781 */           return true;
/*     */         }
/*     */ 
/*     */         
/*     */         public int clearAll(int tx, int ty) {
/* 786 */           TFortification.Stairs.this.shared.NADA.placeFixed(tx, ty);
/* 787 */           return 1;
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean isStructure() {
/* 792 */           return true;
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public void destroy(int tx, int ty) {}
/*     */ 
/*     */         
/*     */         public double strength() {
/* 801 */           return 0.0D;
/*     */         }
/*     */ 
/*     */         
/*     */         public SoundRace sound(int tx, int ty) {
/* 806 */           return this.sound;
/*     */         }
/*     */         
/*     */         public boolean canDestroy(int tx, int ty)
/*     */         {
/* 811 */           return false;
/*     */         }
/*     */       };
/*     */     this.stairC = stairC;
/*     */     this.stairEdge = stairEdge;
/*     */   } public TerrainClearing clearing() {
/* 817 */     return this.clear;
/*     */   }
/*     */   
/*     */   public boolean isPlacable(int tx, int ty) {
/*     */     return true;
/*     */   }
/*     */   
/*     */   protected boolean place(int tx, int ty) {
/*     */     placeRaw(tx, ty);
/*     */     DIR face = DIR.N;
/*     */     int r = 0;
/*     */     for (DIR d : DIR.ORTHO) {
/*     */       if (this.shared.get(tx, ty, d) instanceof TFortification.Tile && !(this.shared.get(tx, ty, d.perpendicular()) instanceof TFortification.Tile) && !is(tx, ty, d.perpendicular())) {
/*     */         face = d;
/*     */         break;
/*     */       } 
/*     */       r++;
/*     */     } 
/*     */     if (!is(tx, ty, face.next(-2)))
/*     */       r |= 0x4; 
/*     */     if (!is(tx, ty, face.next(2)))
/*     */       r |= 0x8; 
/*     */     this.shared.data.set(tx, ty, r);
/*     */     return false;
/*     */   }
/*     */   
/*     */   protected boolean renderAbove(SPRITE_RENDERER r, ShadowBatch s, RenderData.RenderIterator i, int data) {
/*     */     int o = data & 0x3;
/*     */     if ((data & 0x4) != 0)
/*     */       this.stairEdge.render(r, o * 2, i.x(), i.y()); 
/*     */     if ((data & 0x8) != 0)
/*     */       this.stairEdge.render(r, o * 2 + 1, i.x(), i.y()); 
/*     */     return false;
/*     */   }
/*     */   
/*     */   protected boolean renderBelow(SPRITE_RENDERER r, ShadowBatch s, RenderData.RenderIterator i, int data) {
/*     */     int o = (data & 0x3) * 4;
/*     */     this.stairC.render(r, o + (i.ran() & 0x3), i.x(), i.y());
/*     */     return false;
/*     */   }
/*     */   
/*     */   public AVAILABILITY getAvailability(int tx, int ty) {
/*     */     return AVAILABILITY.NORMAL;
/*     */   }
/*     */   
/*     */   public int miniDepth() {
/*     */     return 1;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\tilemap\terrain\TFortification$Stairs.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */