/*     */ package settlement.room.industry.mine;
/*     */ 
/*     */ import init.resources.Minable;
/*     */ import init.sprite.UI.Icon;
/*     */ import java.io.IOException;
/*     */ import settlement.main.SETT;
/*     */ import settlement.overlay.Addable;
/*     */ import settlement.path.AVAILABILITY;
/*     */ import settlement.room.industry.module.INDUSTRY_HASER;
/*     */ import settlement.room.main.Room;
/*     */ import settlement.room.main.RoomBlueprintImp;
/*     */ import settlement.room.main.TmpArea;
/*     */ import settlement.room.main.furnisher.Furnisher;
/*     */ import settlement.room.main.furnisher.FurnisherItem;
/*     */ import settlement.room.main.furnisher.FurnisherItemTile;
/*     */ import settlement.room.main.furnisher.FurnisherStat;
/*     */ import settlement.room.main.util.RoomInit;
/*     */ import settlement.room.main.util.RoomInitData;
/*     */ import settlement.room.sprite.RoomSprite;
/*     */ import settlement.room.sprite.RoomSprite1x1;
/*     */ import settlement.room.sprite.RoomSprite1xN;
/*     */ import settlement.room.sprite.RoomSpriteXxX;
/*     */ import settlement.tilemap.floor.Floors;
/*     */ import snake2d.CORE;
/*     */ import snake2d.Renderer;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.color.ColorImp;
/*     */ import snake2d.util.color.OPACITY;
/*     */ import snake2d.util.datatypes.AREA;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.file.Json;
/*     */ import snake2d.util.map.MAP_BOOLEAN;
/*     */ import snake2d.util.sprite.text.Str;
/*     */ import util.gui.misc.GText;
/*     */ import util.info.GFORMAT;
/*     */ import util.rendering.RenderData;
/*     */ import util.rendering.ShadowBatch;
/*     */ import util.text.D;
/*     */ 
/*     */ final class Constructor
/*     */   extends Furnisher
/*     */ {
/*     */   static final int B_WORK = 1;
/*     */   static final int B_STORAGE = 2;
/*  47 */   private static CharSequence ¤¤problemMore = "¤This room must be partially placed on {0} in order to function.";
/*  48 */   private static CharSequence ¤¤mustBe = "¤Must not be placed on {0}";
/*     */   
/*     */   static {
/*  51 */     D.ts(Constructor.class);
/*     */   }
/*     */   
/*  54 */   final FurnisherStat workers = new FurnisherStat(this)
/*     */     {
/*     */       public double get(AREA area, double fromItems)
/*     */       {
/*  58 */         double am = 0.0D;
/*  59 */         for (COORDINATE c : area.body()) {
/*  60 */           if (area.is(c) && (SETT.MINERALS()).getter.get(c) == Constructor.this.blue.minable && (SETT.MINERALS()).amountD.get(c) > 0.0D && (SETT.ROOMS()).fData.item.get(c) == null)
/*  61 */             am++; 
/*     */         } 
/*  63 */         return Math.floor(am / 1.5D);
/*     */       }
/*     */ 
/*     */       
/*     */       public GText format(GText t, double value) {
/*  68 */         return GFORMAT.i(t, (int)value);
/*     */       }
/*     */     };
/*  71 */   final FurnisherStat deposits = new FurnisherStat(this)
/*     */     {
/*     */       public double get(AREA area, double fromItems)
/*     */       {
/*  75 */         if (area.area() == 0)
/*  76 */           return 0.0D; 
/*  77 */         double am = 0.0D;
/*  78 */         double v = 0.0D;
/*  79 */         for (COORDINATE c : area.body()) {
/*  80 */           if (area.is(c) && (SETT.MINERALS()).getter.get(c) == Constructor.this.blue.minable && (SETT.MINERALS()).amountD.get(c) > 0.0D) {
/*  81 */             am++;
/*  82 */             v += 0.9D + 0.2D * (SETT.MINERALS()).value.get(c);
/*     */           } 
/*     */         } 
/*  85 */         if (am == 0.0D)
/*  86 */           return 0.0D; 
/*  87 */         return v / am;
/*     */       }
/*     */ 
/*     */       
/*     */       public GText format(GText t, double value) {
/*  92 */         return GFORMAT.perc(t, value);
/*     */       }
/*     */     };
/*  95 */   final FurnisherStat efficiency = (FurnisherStat)new FurnisherStat.FurnisherStatEfficiency(this, this.workers);
/*     */   final FurnisherStat output;
/*     */   private final ROOM_MINE blue;
/*     */   private Floors.Floor floor;
/*     */   private COLOR bb;
/*     */   public Addable MINERALS;
/*     */   
/*     */   protected Constructor(RoomInitData init, final ROOM_MINE blue) throws IOException {
/* 103 */     super(init, 2, 4, 88, 44);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 399 */     this.bb = (COLOR)new ColorImp(0, 200, 200);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 410 */     this.MINERALS = new Addable(true, true)
/*     */       {
/*     */         public boolean render(Renderer r, RenderData.RenderIterator it)
/*     */         {
/* 414 */           if ((SETT.ROOMS()).map.is(it.tile()))
/* 415 */             return false; 
/* 416 */           if ((SETT.MINERALS()).getter.get(it.tile()) == Constructor.this.blue.minable) {
/* 417 */             COLOR.unbind();
/* 418 */             double am = 1.0D;
/* 419 */             ColorImp.TMP.interpolate(COLOR.WHITE20, COLOR.WHITE100, am).bind();
/* 420 */             int size = (int)(64.0D * am);
/* 421 */             int off = (64 - size) / 2;
/* 422 */             renderAbove(am, r, it, true);
/* 423 */             COLOR.unbind();
/* 424 */             ((Minable)(SETT.MINERALS()).getter.get(it.tile())).resource.icon().render((SPRITE_RENDERER)r, it.x() + off, it.x() + off + size, it.y() + off, it.y() + off + size);
/* 425 */             return true;
/*     */           } 
/* 427 */           return false;
/*     */         } protected double getBase(AREA area, double[] fromItems) { return Constructor.this.workers.get(area, fromItems) * Constructor.this.efficiency.get(area, fromItems); } }; this.floor = (Floors.Floor)(SETT.FLOOR()).map.read(init.data()); this.blue = blue; Json sp = init.data().json("SPRITES"); RoomSprite1x1 roomSprite1x11 = new RoomSprite1x1(sp, "CONVEYOR_1X1") { protected boolean joins(int tx, int ty, int rx, int ry, DIR d, FurnisherItem item) { return (item.sprite(rx, ry) != null && item.sprite(rx, ry) != this); } public boolean render(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade, boolean isCandle) { this.animationSpeed = Constructor.this.aniSpeed(it.tile()); return super.render(r, s, data, it, degrade, isCandle); } }
/*     */       ; RoomSprite1xN roomSprite1xN1 = new RoomSprite1xN(sp, "STORAGE_1X1_TOP", true) { public void renderAbove(SPRITE_RENDERER ren, ShadowBatch shadowBatch, int data, RenderData.RenderIterator it, double degrade) { Room r = (SETT.ROOMS()).map.get(it.tile()); if (r != null && r instanceof MineInstance) (((MineInstance)r).blueprintI()).job.storage.render(ren, shadowBatch, it.tx(), it.ty(), it.x(), it.y(), it.ran());  } }
/*     */       ; RoomSprite1xN roomSprite1xN2 = new RoomSprite1xN(sp, "STORAGE_1X1_MID", false) { public void renderAbove(SPRITE_RENDERER ren, ShadowBatch shadowBatch, int data, RenderData.RenderIterator it, double degrade) { Room r = (SETT.ROOMS()).map.get(it.tile()); if (r != null && r instanceof MineInstance) (((MineInstance)r).blueprintI()).job.storage.render(ren, shadowBatch, it.tx(), it.ty(), it.x(), it.y(), it.ran());  } }
/*     */       ; RoomSprite1xN roomSprite1xN3 = new RoomSprite1xN(sp, "STORAGE_1X1_END", false) { public void renderAbove(SPRITE_RENDERER ren, ShadowBatch shadowBatch, int data, RenderData.RenderIterator it, double degrade) { Room r = (SETT.ROOMS()).map.get(it.tile()); if (r != null && r instanceof MineInstance) (((MineInstance)r).blueprintI()).job.storage.render(ren, shadowBatch, it.tx(), it.ty(), it.x(), it.y(), it.ran());  } }; RoomSprite1x1 roomSprite1x12 = new RoomSprite1x1(sp, "SLAB_1X1") { public void renderAbove(SPRITE_RENDERER ren, ShadowBatch shadowBatch, int data, RenderData.RenderIterator it, double degrade) { Room r = (SETT.ROOMS()).map.get(it.tile()); if (r != null && r instanceof MineInstance) (((MineInstance)r).blueprintI()).job.storage.render(ren, shadowBatch, it.tx(), it.ty(), it.x(), it.y(), it.ran());  }
/* 432 */       }; this.output = (FurnisherStat)new FurnisherStat.FurnisherStatProduction2(this, blue) { public void renderBelow(Renderer r, RenderData.RenderIterator it) { double v = 0.0D;
/* 433 */           if ((SETT.MINERALS()).getter.get(it.tile()) == Constructor.this.blue.minable) {
/* 434 */             v = 1.0D;
/*     */           }
/* 436 */           if (!(SETT.TERRAIN()).CAVE.is(it.tile()))
/* 437 */             renderUnder(v, r, it, false);  } }; RoomSprite1x1 roomSprite1x13 = new RoomSprite1x1((RoomSprite)roomSprite1x12) { public boolean render(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade, boolean isCandle) { super.render(r, s, data, it, degrade, isCandle); if (!isCandle) { Icon icon = blue.minable.resource.icon(); OPACITY.O99.bind(); icon.render(r, it.x() + 8, it.x() + 64 - 8, it.y() + 8, it.y() + 64 - 8); OPACITY.unbind(); }  return false; } }
/*     */       ; RoomSprite1x1 roomSprite1x14 = new RoomSprite1x1(sp, "AUX_1X1") { public boolean render(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade, boolean isCandle) { this.animationSpeed = Constructor.this.aniSpeed(it.tile()); return super.render(r, s, data, it, degrade, isCandle); } }
/*     */       ; RoomSprite1xN roomSprite1xN4 = new RoomSprite1xN(sp, "AUX_MEDIUM_A_1X1", true) { public boolean render(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade, boolean isCandle) { this.animationSpeed = Constructor.this.aniSpeed(it.tile()); return super.render(r, s, data, it, degrade, isCandle); } }
/*     */       ; RoomSprite1xN roomSprite1xN5 = new RoomSprite1xN(sp, "AUX_MEDIUM_B_1X1", false) { public boolean render(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade, boolean isCandle) { this.animationSpeed = Constructor.this.aniSpeed(it.tile()); return super.render(r, s, data, it, degrade, isCandle); } }
/*     */       ; RoomSpriteXxX roomSpriteXxX = new RoomSpriteXxX(sp, "AUX_BIG_2X2", 2) { public boolean render(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade, boolean isCandle) { this.animationSpeed = Constructor.this.aniSpeed(it.tile()); return super.render(r, s, data, it, degrade, isCandle); } }; RoomSprite1x1 roomSprite1x15 = new RoomSprite1x1(sp, "WORK_1X1") { public boolean render(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade, boolean isCandle) { this.animationSpeed = 0.0D; Room ro = (SETT.ROOMS()).map.get(it.tile()); if (r != null && ro instanceof MineInstance && Job.working((SETT.ROOMS()).data.get(it.tile()))) this.animationSpeed = 1.0D;  return super.render(r, s, data, it, degrade, isCandle); } }; FurnisherItemTile ss = (new Aux(this, true, (RoomSprite)roomSprite1x12, AVAILABILITY.ROOM_SOLID, false)).setData(2); FurnisherItemTile sA = (new Aux(this, true, (RoomSprite)roomSprite1xN1, AVAILABILITY.ROOM_SOLID, false)).setData(2); FurnisherItemTile sm = (new Aux(this, true, (RoomSprite)roomSprite1xN2, AVAILABILITY.ROOM_SOLID, false)).setData(2); FurnisherItemTile sc = (new Aux(this, true, (RoomSprite)roomSprite1xN3, AVAILABILITY.ROOM_SOLID, false)).setData(2); FurnisherItemTile co = new Aux(this, false, (RoomSprite)roomSprite1x11, AVAILABILITY.ROOM_SOLID, false); FurnisherItemTile cc = new Aux(this, false, (RoomSprite)roomSprite1x13, AVAILABILITY.ROOM_SOLID, true); FurnisherItemTile ms = new Aux(this, false, (RoomSprite)roomSprite1x14, AVAILABILITY.ROOM_SOLID, false); FurnisherItemTile mA = new Aux(this, false, (RoomSprite)roomSprite1xN4, AVAILABILITY.ROOM_SOLID, false); FurnisherItemTile mB = new Aux(this, false, (RoomSprite)roomSprite1xN5, AVAILABILITY.ROOM_SOLID, false); FurnisherItemTile ml = new Aux(this, false, (RoomSprite)roomSpriteXxX, AVAILABILITY.ROOM_SOLID, false); FurnisherItemTile ww = (new Aux(this, true, (RoomSprite)roomSprite1x15, AVAILABILITY.ROOM_SOLID, false)).setData(1); flush(1, 1, 3); flush(3);
/*     */   } private class Aux extends FurnisherItemTile {
/* 443 */     public Aux(Furnisher p, boolean mustBeReachable, RoomSprite sprite, AVAILABILITY availability, boolean canGoCandle) { super(p, mustBeReachable, sprite, availability, canGoCandle); } public CharSequence isPlacable(int tx, int ty, MAP_BOOLEAN roomIs, FurnisherItem it, int rx, int ry) { return null; } } public Addable overlay() { return this.MINERALS; }
/*     */   public void putFloor(int tx, int ty, int upgrade, AREA area) { this.floor.placeFixed(tx, ty); }
/*     */   public CharSequence constructionProblem(AREA area) { if (this.workers.get(area, 0.0D) <= 0.0D)
/*     */       return (CharSequence)Str.TMP.clear().add(¤¤problemMore).insert(0, this.blue.minable.name);  return null; }
/*     */   public void renderEmbryo(SPRITE_RENDERER r, int mask, RenderData.RenderIterator it, boolean isFloored, AREA area, boolean active) { super.renderEmbryo(r, mask, it, isFloored, area, active); if (active)
/*     */       this.bb.bind();  SETT.GROUND().renderMinerals(CORE.renderer(), it.tile(), it.ran(), it.x(), it.y());
/* 449 */     COLOR.unbind(); } public boolean usesArea() { return true; }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean mustBeIndoors() {
/* 454 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean mustBeOutdoors() {
/* 459 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public CharSequence placable(int tx, int ty, FurnisherItem item, FurnisherItemTile tile) {
/* 464 */     if ((SETT.MINERALS()).getter.get(tx, ty) != null && (SETT.MINERALS()).getter.get(tx, ty) != this.blue.minable)
/* 465 */       return (CharSequence)Str.TMP.clear().add(¤¤mustBe).insert(0, ((Minable)(SETT.MINERALS()).getter.get(tx, ty)).name); 
/* 466 */     return super.placable(tx, ty, item, tile);
/*     */   }
/*     */ 
/*     */   
/*     */   public Room create(TmpArea area, RoomInit init) {
/* 471 */     return (Room)new MineInstance(this.blue, area, init);
/*     */   }
/*     */ 
/*     */   
/*     */   public RoomBlueprintImp blue() {
/* 476 */     return (RoomBlueprintImp)this.blue;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean canBeCopied() {
/* 499 */     return false;
/*     */   }
/*     */   
/*     */   private double aniSpeed(int tile) {
/* 503 */     Room r = (SETT.ROOMS()).map.get(tile);
/* 504 */     if (r != null && r instanceof MineInstance) {
/* 505 */       MineInstance ins = (MineInstance)r;
/* 506 */       return ins.workage / ins.jobs.size();
/*     */     } 
/*     */     
/* 509 */     return 0.0D;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\industry\mine\Constructor.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */