/*     */ package settlement.room.food.farm;
/*     */ 
/*     */ import init.sprite.SPRITES;
/*     */ import init.sprite.UI.UI;
/*     */ import init.sprite.game.Sheet;
/*     */ import init.sprite.game.SheetData;
/*     */ import init.sprite.game.SheetType;
/*     */ import java.io.IOException;
/*     */ import settlement.main.SETT;
/*     */ import settlement.overlay.Addable;
/*     */ import settlement.room.industry.module.INDUSTRY_HASER;
/*     */ import settlement.room.industry.module.Industry;
/*     */ import settlement.room.industry.module.IndustryResource;
/*     */ import settlement.room.main.Room;
/*     */ import settlement.room.main.RoomBlueprintImp;
/*     */ import settlement.room.main.TmpArea;
/*     */ import settlement.room.main.furnisher.Furnisher;
/*     */ import settlement.room.main.furnisher.FurnisherStat;
/*     */ import settlement.room.main.util.RoomInit;
/*     */ import settlement.room.main.util.RoomInitData;
/*     */ import settlement.tilemap.ground.GroundType;
/*     */ import snake2d.CORE;
/*     */ import snake2d.Renderer;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.color.ColorImp;
/*     */ import snake2d.util.datatypes.AREA;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.sets.LIST;
/*     */ import util.gui.misc.GText;
/*     */ import util.info.GFORMAT;
/*     */ import util.rendering.RenderData;
/*     */ import util.text.D;
/*     */ 
/*     */ final class Constructor
/*     */   extends Furnisher {
/*  39 */   private static CharSequence ¤¤warning = "Fertility for this farm is very low, which will result in low yields. It can be improved by digging water around the farm. Proceed anyway?"; final boolean isIndoors; private final ROOM_FARM blue;
/*     */   static {
/*  41 */     D.ts(Constructor.class);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*  46 */   final FurnisherStat fertility = new FurnisherStat(this, 1.0E-4D)
/*     */     {
/*     */       public GText format(GText t, double value)
/*     */       {
/*  50 */         return GFORMAT.perc(t, value);
/*     */       }
/*     */ 
/*     */ 
/*     */       
/*     */       public double get(AREA area, double fromItems) {
/*  56 */         double v = 0.0D;
/*  57 */         for (COORDINATE c : area.body()) {
/*     */           
/*  59 */           if (area.is(c)) {
/*  60 */             v += Constructor.this.fertility(c.x(), c.y());
/*     */           }
/*     */         } 
/*     */         
/*  64 */         return v / area.area();
/*     */       }
/*     */ 
/*     */       
/*     */       public double max() {
/*  69 */         return Constructor.this.isIndoors ? 1.0D : 1.2D;
/*     */       }
/*     */ 
/*     */       
/*     */       public double min() {
/*  74 */         return Constructor.this.isIndoors ? 0.9D : 0.0D;
/*     */       }
/*     */     };
/*     */ 
/*     */   
/*  79 */   final FurnisherStat workers = new FurnisherStat(this, 0.01D)
/*     */     {
/*     */       public GText format(GText t, double value)
/*     */       {
/*  83 */         return GFORMAT.f(t, value);
/*     */       }
/*     */ 
/*     */       
/*     */       public double get(AREA area, double fromItems) {
/*  88 */         return area.area() * ROOM_FARM.WORKERPERTILEI;
/*     */       }
/*     */     };
/*     */   final FurnisherStat output; final FurnisherStat irri; private final LIST<Sheet> sheets; private final Addable overlay;
/*     */   
/*     */   public double fertility(int tx, int ty) {
/*  94 */     if (!this.isIndoors) {
/*  95 */       return ((GroundType)(SETT.GROUND()).MAP.get(tx, ty)).farm;
/*     */     }
/*  97 */     return (SETT.TERRAIN()).MOUNTAIN.isMountain(tx, ty) ? 1.0D : 0.9D;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected Constructor(final ROOM_FARM blue, RoomInitData init) throws IOException {
/* 108 */     super(init, 0, 4, 88, 44);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 190 */     this.overlay = new Addable(true, false) { protected double getBase(AREA area, double[] acc) { double f = 0.0D; for (COORDINATE c : area.body()) { if (area.is(c))
/*     */               f += Constructor.this.fertility(c.x(), c.y());  }
/*     */            return ROOM_FARM.WORKERPERTILEI * f * ((IndustryResource)((Industry)blue.industries().get(0)).outs().get(0)).rate; } }
/* 193 */       ; this.irri = (FurnisherStat)new FurnisherStat.FurnisherStatIrrigation(this, blue); this.output = (FurnisherStat)new FurnisherStat.FurnisherStatProduction2(this, blue, 0.01D) { public void renderBelow(Renderer r, RenderData.RenderIterator it) { double d = ((GroundType)(SETT.GROUND()).MAP.get(it.tile())).farm / (SETT.GROUND()).types.NORMAL.farm;
/* 194 */           d = CLAMP.d(d, 0.0D, 1.0D);
/* 195 */           d *= d;
/* 196 */           renderUnder(d, r, it, false);
/* 197 */           if (!(SETT.ROOMS()).placement.embryo.is(it.tile()) && SETT.TERRAIN().get(it.tile()).clearing().can() && !(SETT.TERRAIN()).WATER.DEEP.is(it.tile())) {
/* 198 */             double w = (SETT.GROUND()).MOISTURE_TOT.get(it.tile());
/* 199 */             w = CLAMP.d(w, 0.0D, 1.0D);
/* 200 */             if (w > 0.0D) {
/* 201 */               ColorImp.TMP.interpolate(COLOR.ORANGE100, COLOR.BLUE100, w).bind();
/* 202 */               int s = (int)(16.0D + w * 3.0D * 64.0D / 4.0D);
/* 203 */               int x1 = it.x() + (64 - s) / 2;
/* 204 */               int y1 = it.y() + (64 - s) / 2;
/*     */               
/* 206 */               (UI.icons()).s.drop.render((SPRITE_RENDERER)r, x1, x1 + s, y1, y1 + s);
/*     */             } 
/*     */           }  } }
/*     */       ;
/*     */     this.isIndoors = init.data().bool("INDOORS");
/*     */     this.blue = blue;
/*     */     this.sheets = SPRITES.GAME().sheets((SheetType)SheetType.s1x1, "_FARM_DIRT", null);
/*     */   } public boolean usesArea() { return true; } public boolean mustBeIndoors() { return this.isIndoors; }
/*     */   public boolean mustBeOutdoors() { return !this.isIndoors; }
/* 215 */   public Addable overlay() { if (!this.isIndoors)
/* 216 */       return this.overlay; 
/* 217 */     return null; }
/*     */ 
/*     */   
/*     */   public RoomBlueprintImp blue() {
/*     */     return (RoomBlueprintImp)this.blue;
/*     */   }
/*     */   
/* 224 */   void renderTill(SPRITE_RENDERER r, RenderData.RenderIterator it, AREA area, double till) { int d = direction(it, area);
/*     */     
/* 226 */     int sheet = 0;
/* 227 */     int rot = 0;
/*     */     
/* 229 */     if (area.is(it.tx(), it.ty(), (DIR)DIR.ORTHO.get(d))) {
/* 230 */       if (area.is(it.tx(), it.ty(), (DIR)DIR.ORTHO.get(d + 2))) {
/* 231 */         sheet = 2;
/* 232 */         rot = d + 2 * (it.ran() & 0x1);
/*     */       } else {
/* 234 */         sheet = 1;
/* 235 */         rot = d;
/*     */       } 
/* 237 */     } else if (area.is(it.tx(), it.ty(), (DIR)DIR.ORTHO.get(d + 2))) {
/* 238 */       sheet = 1;
/* 239 */       rot = d + 2;
/*     */     } else {
/* 241 */       rot = d + 2 * (it.ran() & 0x1);
/*     */     } 
/*     */     
/* 244 */     renderTill(r, it, till, sheet, rot); }
/*     */   public void putFloor(int tx, int ty, int upgrade, AREA area) { int m = 0; for (DIR d : DIR.ORTHO) {
/*     */       if (area.is(tx, ty, d))
/*     */         m |= d.mask(); 
/*     */     } 
/*     */     (SETT.ROOMS()).fData.spriteData.set(tx, ty, m);
/* 250 */     (SETT.FLOOR()).clearer.clear(tx, ty); } private void renderTill(SPRITE_RENDERER r, RenderData.RenderIterator it, double till, int t, int rot) { till = 1.0D - till;
/* 251 */     int aa = (int)(till * (this.sheets.size() / 3 - 1));
/*     */     
/* 253 */     t = 3 * aa + t;
/* 254 */     int data = SheetType.s1x1.tile((Sheet)this.sheets.get(0), SheetData.DUMMY, 0, it.ran(), rot);
/* 255 */     ((Sheet)this.sheets.get(t)).render(SheetData.DUMMY, it.x(), it.y(), it, r, data, it.ran(), 0.0D); }
/*     */   public void renderEmbryo(SPRITE_RENDERER r, int mask, RenderData.RenderIterator it, boolean isFloored, AREA area, boolean active) { if (isFloored && active) {
/*     */       COLOR c = CORE.renderer().colorGet(); COLOR.unbind(); renderTill(r, it, area, 0.0D); c.bind();
/*     */     } 
/* 259 */     super.renderEmbryo(r, mask, it, isFloored, area, active); } int direction(RenderData.RenderIterator it, AREA area) { return it.ran(area.body().x1(), area.body().y1()) & 0x1; }
/*     */ 
/*     */ 
/*     */   
/*     */   public Room create(TmpArea area, RoomInit init) {
/* 264 */     return (Room)new FarmInstance(this.blue, area, init);
/*     */   }
/*     */ 
/*     */   
/*     */   public CharSequence warning(AREA area) {
/* 269 */     double d = this.fertility.get(area, 0.0D);
/* 270 */     if (d < 0.5D)
/* 271 */       return ¤¤warning; 
/* 272 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\food\farm\Constructor.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */