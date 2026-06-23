/*     */ package settlement.room.main.util;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import settlement.main.SETT;
/*     */ import settlement.path.AVAILABILITY;
/*     */ import settlement.path.AvailabilityListener;
/*     */ import settlement.room.main.ROOMS;
/*     */ import settlement.room.main.Room;
/*     */ import settlement.room.main.RoomBlueprint;
/*     */ import settlement.tilemap.terrain.Terrain;
/*     */ import snake2d.util.MATH;
/*     */ import snake2d.util.datatypes.AREA;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.datatypes.Rec;
/*     */ import snake2d.util.datatypes.RecShort;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.file.SAVABLE;
/*     */ import snake2d.util.map.MAP_BOOLEAN;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import util.GUTIL;
/*     */ import util.info.INFO;
/*     */ import util.text.D;
/*     */ import util.text.Dic;
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class RoomIsolation
/*     */ {
/*  32 */   private final int CHUNKSIZE = 32;
/*  33 */   private final int CHUNCS = Integer.numberOfTrailingZeros(32);
/*  34 */   private final Chunk[][] chunks = new Chunk[(int)Math.ceil(SETT.THEIGHT / 32.0D)][(int)Math.ceil(SETT.TWIDTH / 32.0D)];
/*  35 */   private final ArrayList<Chunk> toUpdate = new ArrayList(this.chunks.length * (this.chunks[0]).length);
/*     */ 
/*     */   
/*  38 */   private final Rec rec = new Rec();
/*     */   public final INFO info;
/*  40 */   private final RoomAreaWrapper wrap = new RoomAreaWrapper();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private MAP_BOOLEAN isWall;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final MAP_BOOLEAN wall;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   final SAVABLE saver;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void setChanged(int tx, int ty, AVAILABILITY a, AVAILABILITY old) {
/*  62 */     if (((a.player < 0.0D) ? true : false) != ((old.player < 0.0D) ? true : false)) {
/*  63 */       for (int di = 0; di < DIR.ALL.size(); di++) {
/*  64 */         DIR d = (DIR)DIR.ALL.get(di);
/*  65 */         Room r = (Room)(SETT.ROOMS()).map.get(tx, ty, d);
/*  66 */         setChanged(r, tx + d.x(), ty + d.y());
/*     */       } 
/*     */     }
/*     */   }
/*     */   
/*     */   private void setChanged(Room r, int x, int y) {
/*  72 */     if (r != null && r.constructor() != null && r.constructor().needsIsolation()) {
/*  73 */       int mx = r.mX(x, y) >> this.CHUNCS;
/*  74 */       int my = r.mY(x, y) >> this.CHUNCS;
/*  75 */       Chunk c = this.chunks[my][mx];
/*  76 */       if (!c.added) {
/*  77 */         this.toUpdate.add(c);
/*  78 */         c.added = true;
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public void update() {
/*  84 */     while (!this.toUpdate.isEmpty()) {
/*  85 */       Chunk ch = (Chunk)this.toUpdate.removeLast();
/*     */       
/*  87 */       for (COORDINATE c : ch.body) {
/*  88 */         Room r = (Room)(SETT.ROOMS()).map.get(c);
/*  89 */         if (r != null && r.mX(c.x(), c.y()) == c.x() && r.mY(c.x(), c.y()) == c.y()) {
/*  90 */           r.isolationSet(c.x(), c.y(), getProspect(r.blueprint(), (AREA)this.wrap.init(r, c.x(), c.y()), null));
/*  91 */           this.wrap.done();
/*     */         } 
/*     */       } 
/*  94 */       ch.added = false;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public double getProspect(RoomBlueprint blue, AREA r, MAP_BOOLEAN isWall) {
/* 102 */     this.isWall = isWall;
/*     */     
/* 104 */     double unwalled = 0.0D;
/* 105 */     double total = 0.0D;
/* 106 */     this.rec.set(r.body());
/* 107 */     GUTIL.marker().init(this);
/*     */     
/* 109 */     for (COORDINATE c : this.rec) {
/*     */       
/* 111 */       if (!r.is(c) || !isEdge(r, c)) {
/*     */         continue;
/*     */       }
/* 114 */       total++;
/* 115 */       for (DIR d : DIR.ALL) {
/*     */         
/* 117 */         if (!SETT.IN_BOUNDS(c, d)) {
/* 118 */           unwalled++;
/*     */           continue;
/*     */         } 
/* 121 */         if (r.is(c, d)) {
/*     */           continue;
/*     */         }
/* 124 */         if (!this.wall.is(c, d) && !GUTIL.marker().is(c, d)) {
/* 125 */           if (blue == (SETT.ROOMS()).HOME) {
/* 126 */             if (blue != (SETT.ROOMS()).map.blueprintImp.get(c, d)) {
/* 127 */               GUTIL.marker().set(c, d, true);
/* 128 */               unwalled++;
/*     */             }  continue;
/*     */           } 
/* 131 */           GUTIL.marker().set(c, d, true);
/* 132 */           unwalled++;
/*     */         } 
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 139 */     GUTIL.filler().done();
/*     */     
/* 141 */     int bonus = (int)Math.ceil(total / 10.0D);
/* 142 */     double v = total - unwalled + bonus;
/* 143 */     v /= total;
/* 144 */     v = CLAMP.d(v, 0.0D, 1.0D);
/* 145 */     v = MATH.pow15.pow(v);
/* 146 */     return v;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public RoomIsolation(ROOMS r) {
/* 152 */     this.wall = new MAP_BOOLEAN()
/*     */       {
/*     */         public boolean is(int tile)
/*     */         {
/* 156 */           throw new RuntimeException();
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean is(int tx, int ty) {
/* 161 */           if (!SETT.IN_BOUNDS(tx, ty))
/* 162 */             return false; 
/* 163 */           if (RoomIsolation.this.isWall != null && RoomIsolation.this.isWall.is(tx, ty))
/* 164 */             return true; 
/* 165 */           Terrain.TerrainTile t = SETT.TERRAIN().get(tx, ty);
/* 166 */           if (t instanceof settlement.tilemap.terrain.TFortification.Normal)
/* 167 */             return true; 
/* 168 */           return (t.clearing().isStructure() && t.getAvailability(tx, ty) != null && (t.getAvailability(tx, ty)).player < 0.0D);
/*     */         }
/*     */       };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 181 */     this.saver = new SAVABLE() { public void save(FilePutter file) {}
/*     */         
/*     */         public void load(FileGetter file) throws IOException {}
/*     */         
/*     */         public void clear() {} }
/*     */       ;
/*     */     D.gInit(this);
/*     */     this.info = new INFO(Dic.¤¤Isolation, D.g("desc", "Insulation prevents room degradation and sound pollution. Surrounding walls increase insulation, while doors and gaps decrease it. Poorly insulated rooms need more maintenance. Poorly insulated homes degrade furniture faster."));
/*     */     for (int y = 0; y < this.chunks.length; y++) {
/*     */       for (int x = 0; x < (this.chunks[y]).length; x++)
/*     */         this.chunks[y][x] = new Chunk(x, y); 
/*     */     } 
/*     */   }
/*     */   
/*     */   private boolean isEdge(AREA r, COORDINATE c) {
/*     */     for (DIR d : DIR.ALL) {
/*     */       if (!r.is(c, d))
/*     */         return true; 
/*     */     } 
/*     */     return false;
/*     */   }
/*     */   
/*     */   private class Chunk {
/*     */     Chunk(int x1, int y1) {
/* 205 */       x1 *= 32;
/* 206 */       y1 *= 32;
/* 207 */       int x2 = x1 + 32;
/* 208 */       x2 = Math.min(x2, SETT.TWIDTH);
/* 209 */       int y2 = y1 + 32;
/* 210 */       y2 = Math.min(y2, SETT.THEIGHT);
/* 211 */       this.body = new RecShort(x1, x2, y1, y2);
/*     */     }
/*     */     
/*     */     private final RecShort body;
/*     */     private boolean added;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\mai\\util\RoomIsolation.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */