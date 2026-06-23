/*     */ package settlement.tilemap;
/*     */ 
/*     */ import init.resources.Minable;
/*     */ import init.resources.RESOURCE;
/*     */ import settlement.main.SETT;
/*     */ import settlement.tilemap.terrain.TGrowable;
/*     */ import settlement.tilemap.terrain.Terrain;
/*     */ import snake2d.util.datatypes.BODY_HOLDER;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.datatypes.Rec;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sets.Bitmap1D;
/*     */ import snake2d.util.sets.LIST;
/*     */ import snake2d.util.sets.LinkedList;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class TerrainHotspots
/*     */ {
/*  23 */   private ArrayList<TerrainHotSpot> all = new ArrayList(0);
/*     */ 
/*     */   
/*     */   public static final class TerrainHotSpot
/*     */     implements BODY_HOLDER
/*     */   {
/*     */     public final RESOURCE res;
/*     */     
/*     */     public final int type;
/*     */     
/*     */     private final int subType;
/*     */     
/*     */     public final SPRITE icon;
/*     */     private final Rec rec;
/*     */     
/*     */     private TerrainHotSpot(RESOURCE res, int type, int subType, SPRITE icon, Rec rec) {
/*  39 */       this.type = type;
/*  40 */       this.subType = subType;
/*  41 */       this.icon = icon;
/*  42 */       this.rec = rec;
/*  43 */       this.res = res;
/*  44 */       rec.incrW(6.0D);
/*  45 */       rec.incrH(6.0D);
/*  46 */       rec.incrX(-3.0D);
/*  47 */       rec.incrY(-3.0D);
/*     */     }
/*     */ 
/*     */     
/*     */     public RECTANGLE body() {
/*  52 */       return (RECTANGLE)this.rec;
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public LIST<TerrainHotSpot> all() {
/*  58 */     return (LIST<TerrainHotSpot>)this.all;
/*     */   }
/*     */ 
/*     */   
/*     */   public void init() {
/*  63 */     Bitmap1D checked = new Bitmap1D(SETT.TAREA, false);
/*     */     
/*  65 */     LinkedList<TerrainHotSpot> all = new LinkedList();
/*     */     
/*  67 */     for (COORDINATE c : new Rec(SETT.TILE_BOUNDS)) {
/*     */       
/*  69 */       TerrainHotSpot sp = make(c.x(), c.y(), checked);
/*  70 */       if (sp != null) {
/*  71 */         all.add(sp);
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/*  76 */     LinkedList<TerrainHotSpot> all2 = new LinkedList();
/*     */     
/*  78 */     while (!all.isEmpty()) {
/*  79 */       TerrainHotSpot h = (TerrainHotSpot)all.removeFirst();
/*     */       
/*  81 */       boolean fuck = false;
/*  82 */       for (TerrainHotSpot s2 : all2) {
/*  83 */         if (h.type == s2.type && h.subType == s2.subType && h.rec.touches(s2)) {
/*  84 */           s2.rec.unify((RECTANGLE)h.rec);
/*  85 */           fuck = true;
/*     */         } 
/*     */       } 
/*  88 */       if (!fuck) {
/*  89 */         all2.add(h);
/*     */       }
/*     */     } 
/*  92 */     this.all = new ArrayList((Iterable)all2);
/*     */   }
/*     */   
/*     */   private TerrainHotSpot make(int tx, int ty, Bitmap1D checked) {
/*  96 */     if (checked.get(tx + ty * SETT.TWIDTH)) {
/*  97 */       return null;
/*     */     }
/*  99 */     int d = 8;
/*     */     
/* 101 */     Terrain.TerrainTile t = SETT.TERRAIN().get(tx, ty);
/* 102 */     if (t != null && t instanceof TGrowable) {
/* 103 */       Rec r = new Rec(1.0D);
/* 104 */       r.moveX1Y1(tx, ty);
/* 105 */       checked.set(tx + ty * SETT.TWIDTH, true);
/*     */       while (true) {
/* 107 */         if (join(r, t, r.x1() - d, r.x1(), r.y1(), r.y2(), checked))
/*     */           continue; 
/* 109 */         if (join(r, t, r.x2(), r.x2() + d, r.y1(), r.y2(), checked))
/*     */           continue; 
/* 111 */         if (join(r, t, r.x1() - d, r.x2() + d, r.y1() - d, r.y1(), checked))
/*     */           continue; 
/* 113 */         if (join(r, t, r.x1() - d, r.x2() + d, r.y2(), r.y2() + d, checked))
/*     */           continue; 
/*     */         break;
/*     */       } 
/* 117 */       if (r.width() * r.height() < 9)
/* 118 */         return null; 
/* 119 */       return new TerrainHotSpot(((TGrowable)t).growable.resource, 0, ((TGrowable)t).gIndex, t.getIcon(), r);
/*     */     } 
/* 121 */     if ((SETT.MINERALS()).getter.get(tx, ty) != null) {
/* 122 */       Rec r = new Rec();
/* 123 */       r.moveX1Y1(tx, ty);
/* 124 */       checked.set(tx + ty * SETT.TWIDTH, true);
/* 125 */       Minable m = (Minable)(SETT.MINERALS()).getter.get(tx, ty);
/*     */       while (true) {
/* 127 */         if (join(r, m, r.x1() - d, r.x1(), r.y1(), r.y2(), checked))
/*     */           continue; 
/* 129 */         if (join(r, m, r.x2(), r.x2() + d, r.y1(), r.y2(), checked))
/*     */           continue; 
/* 131 */         if (join(r, m, r.x1() - d, r.x2() + d, r.y1() - d, r.y1(), checked))
/*     */           continue; 
/* 133 */         if (join(r, m, r.x1() - d, r.x2() + d, r.y2(), r.y2() + d, checked))
/*     */           continue; 
/*     */         break;
/*     */       } 
/* 137 */       if (r.width() * r.height() < 9)
/* 138 */         return null; 
/* 139 */       return new TerrainHotSpot(m.resource, 1, m.index, (SPRITE)m.resource.icon(), r);
/*     */     } 
/* 141 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   private boolean join(Rec r, Terrain.TerrainTile t, int x1, int x2, int y1, int y2, Bitmap1D checked) {
/* 146 */     boolean j = false;
/* 147 */     for (int y = y1; y < y2; y++) {
/* 148 */       for (int x = x1; x < x2; x++) {
/* 149 */         if (SETT.IN_BOUNDS(x, y))
/*     */         {
/* 151 */           if (t.is(x, y)) {
/* 152 */             checked.set(x + y * SETT.TWIDTH, true);
/* 153 */             r.unify(x, y);
/* 154 */             j = true;
/*     */           }  } 
/*     */       } 
/*     */     } 
/* 158 */     return j;
/*     */   }
/*     */ 
/*     */   
/*     */   private boolean join(Rec r, Minable t, int x1, int x2, int y1, int y2, Bitmap1D checked) {
/* 163 */     boolean j = false;
/* 164 */     for (int y = y1; y < y2; y++) {
/* 165 */       for (int x = x1; x < x2; x++) {
/* 166 */         if (SETT.IN_BOUNDS(x, y))
/*     */         {
/* 168 */           if ((SETT.MINERALS()).getter.get(x, y) == t) {
/* 169 */             checked.set(x + y * SETT.TWIDTH, true);
/* 170 */             r.unify(x, y);
/* 171 */             j = true;
/*     */           }  } 
/*     */       } 
/*     */     } 
/* 175 */     return j;
/*     */   }
/*     */   
/*     */   public LIST<TerrainHotSpot> ALL() {
/* 179 */     return (LIST<TerrainHotSpot>)this.all;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\tilemap\TerrainHotspots.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */