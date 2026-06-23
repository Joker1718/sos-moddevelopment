/*     */ package settlement.tilemap.terrain;
/*     */ 
/*     */ import game.audio.SoundRace;
/*     */ import init.resources.RESOURCE;
/*     */ import settlement.job.Job;
/*     */ import settlement.main.SETT;
/*     */ import settlement.path.AVAILABILITY;
/*     */ import settlement.thing.pointlight.LOS;
/*     */ import settlement.tilemap.TILE_FIXABLE;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.color.ColorImp;
/*     */ import snake2d.util.color.OPACITY;
/*     */ import snake2d.util.file.Json;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import snake2d.util.sprite.TILE_SHEET;
/*     */ import util.rendering.RenderData;
/*     */ import util.rendering.ShadowBatch;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class TFortificationTileBroken
/*     */   extends TFortification.Tile
/*     */   implements TILE_FIXABLE
/*     */ {
/* 477 */   final TerrainClearing clearing = new TerrainClearing()
/*     */     {
/*     */       
/*     */       public RESOURCE clear1(int tx, int ty)
/*     */       {
/* 482 */         TFortification.TFortificationTileBroken.this.shared.NADA.placeFixed(tx, ty);
/* 483 */         return null;
/*     */       }
/*     */ 
/*     */       
/*     */       public boolean can() {
/* 488 */         return true;
/*     */       }
/*     */ 
/*     */       
/*     */       public int clearAll(int tx, int ty) {
/* 493 */         TFortification.TFortificationTileBroken.this.shared.NADA.placeFixed(tx, ty);
/* 494 */         return 1;
/*     */       }
/*     */ 
/*     */       
/*     */       public SoundRace sound(int tx, int ty) {
/* 499 */         return TFortification.TFortificationTileBroken.this.fort.sound;
/*     */       }
/*     */ 
/*     */       
/*     */       public boolean isStructure() {
/* 504 */         return false;
/*     */       }
/*     */ 
/*     */       
/*     */       public double strength() {
/* 509 */         return 0.0D;
/*     */       }
/*     */ 
/*     */       
/*     */       public boolean canDestroy(int tx, int ty) {
/* 514 */         return false;
/*     */       }
/*     */     };
/*     */ 
/*     */   
/*     */   TFortificationTileBroken(String key, Terrain t, Json data, Json text, SPRITE icon, TILE_SHEET sheet, TFortification tFortification) {
/* 520 */     super("FORTIFICATION_B_" + key, t, text.text("NAME") + " (" + text.text("NAME") + ")", icon, (COLOR)new ColorImp(data, "MINIMAP_COLOR"), tFortification);
/*     */   }
/*     */ 
/*     */   
/*     */   public LOS los(int tx, int ty) {
/* 525 */     return LOS.OPEN;
/*     */   }
/*     */ 
/*     */   
/*     */   public int heightEnd(int tx, int ty) {
/* 530 */     return this.fort.height / 2;
/*     */   }
/*     */ 
/*     */   
/*     */   public int heightEnt(int tx, int ty) {
/* 535 */     return this.fort.height / 2;
/*     */   }
/*     */ 
/*     */   
/*     */   boolean wallJoiner() {
/* 540 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean wallIsWally() {
/* 545 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isMassiveWall() {
/* 550 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean renderAbove(SPRITE_RENDERER r, ShadowBatch s, RenderData.RenderIterator i, int data) {
/* 555 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean renderBelow(SPRITE_RENDERER r, ShadowBatch s, RenderData.RenderIterator i, int data) {
/* 560 */     int x = i.x();
/* 561 */     int y = i.y();
/* 562 */     int ran = i.ran();
/*     */     
/* 564 */     int code = data & 0xF;
/* 565 */     int c = code;
/*     */ 
/*     */     
/* 568 */     if (code == 0) {
/* 569 */       c = 208;
/* 570 */       c += ran & 0xF;
/* 571 */     } else if (code == 15) {
/* 572 */       c = 224;
/* 573 */       c += ran & 0xF;
/*     */     } else {
/* 575 */       c += 144 + (ran & 0x3) * 16;
/*     */     } 
/*     */     
/* 578 */     renderEdges(r, s, i, data);
/* 579 */     this.fort.tint.color.bind();
/* 580 */     this.fort.sheet.render(r, c, x, y);
/* 581 */     s.setHeight(this.fort.sHeight / 2).setDistance2Ground(0.0D);
/* 582 */     this.fort.sheet.render((SPRITE_RENDERER)s, c, x, y);
/*     */     
/* 584 */     int cor = data >> 4 & 0xF;
/* 585 */     if (cor != 0) {
/* 586 */       this.fort.sheet.render(r, 128 + cor, x, y);
/*     */     }
/* 588 */     COLOR.unbind();
/*     */     
/* 590 */     if (code == 0 || code == 15) {
/*     */       
/* 592 */       OPACITY.O99.bind();
/* 593 */       this.fort.sheet.renderTextured((SETT.ROOMS()).util.filth.texture(0.75D, i.ran()), c, x, y);
/* 594 */       OPACITY.unbind();
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 599 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public AVAILABILITY getAvailability(int x, int y) {
/* 604 */     return AVAILABILITY.NORMAL;
/*     */   }
/*     */ 
/*     */   
/*     */   public TerrainClearing clearing() {
/* 609 */     return this.clearing;
/*     */   }
/*     */ 
/*     */   
/*     */   public Job fixJob(int tx, int ty) {
/* 614 */     return (Job)(SETT.JOBS()).build_fort.all.get(this.fort.index());
/*     */   }
/*     */ 
/*     */   
/*     */   public Terrain.TerrainTile getTerrain(int tx, int ty) {
/* 619 */     return this.fort.tile;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\tilemap\terrain\TFortification$TFortificationTileBroken.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */