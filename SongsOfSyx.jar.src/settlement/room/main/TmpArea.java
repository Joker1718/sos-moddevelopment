/*     */ package settlement.room.main;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import settlement.main.SETT;
/*     */ import settlement.maintenance.ROOM_DEGRADER;
/*     */ import settlement.path.AVAILABILITY;
/*     */ import settlement.path.finders.SFinderFindable;
/*     */ import settlement.room.main.construction.ConstructionData;
/*     */ import settlement.room.main.furnisher.Furnisher;
/*     */ import settlement.room.main.util.RoomAreaWrapper;
/*     */ import snake2d.Renderer;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.color.ColorImp;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.COORDINATEE;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.datatypes.Rec;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.map.MAP_SETTER;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.GUTIL;
/*     */ import util.rendering.RenderData;
/*     */ import util.rendering.ShadowBatch;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class TmpArea
/*     */   implements MAP_SETTER, ROOMA
/*     */ {
/*  32 */   private final RoomBlueprint b = new RoomBlueprint("_TMPAREA")
/*     */     {
/*     */       protected void update(double ds)
/*     */       {
/*  36 */         if (TmpArea.this.lastUser != null) {
/*  37 */           TmpArea.this.error();
/*     */         }
/*     */       }
/*     */ 
/*     */       
/*     */       public SFinderFindable service(int tx, int ty) {
/*  43 */         return null;
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       protected void save(FilePutter file) {}
/*     */ 
/*     */ 
/*     */       
/*     */       public COLOR miniC(int tx, int ty) {
/*  54 */         return null;
/*     */       }
/*     */ 
/*     */       
/*     */       protected void load(FileGetter file) throws IOException {
/*  59 */         clear();
/*     */       }
/*     */ 
/*     */       
/*     */       protected void clear() {
/*  64 */         TmpArea.this.clear();
/*     */       }
/*     */ 
/*     */       
/*     */       public COLOR miniCPimped(ColorImp origional, int tx, int ty, boolean northern, boolean southern) {
/*  69 */         return (COLOR)origional;
/*     */       }
/*     */     };
/*     */   
/*     */   private final Instance ins;
/*     */   private Object lastUser;
/*  75 */   private StackTraceElement[] els = new StackTraceElement[0];
/*  76 */   private static final RoomAreaWrapper wrap = new RoomAreaWrapper();
/*     */   private Furnisher cons;
/*     */   private boolean removeFloor;
/*     */   
/*     */   TmpArea(ROOMS m) {
/*  81 */     this.ins = new Instance(m, this.b);
/*     */   }
/*     */   
/*     */   void init(Object user) {
/*  85 */     if (this.lastUser != null)
/*  86 */       error(); 
/*  87 */     this.lastUser = user;
/*  88 */     this.cons = null;
/*  89 */     this.removeFloor = true;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDontRemoveFloor() {
/*  94 */     this.removeFloor = false;
/*     */   }
/*     */   
/*     */   public void setRemoveFloor() {
/*  98 */     this.removeFloor = true;
/*     */   }
/*     */ 
/*     */   
/*     */   public void set(Room o, int rx, int ry) {
/* 103 */     ROOMA a = wrap.init(o, rx, ry);
/* 104 */     this.cons = o.constructor();
/* 105 */     GUTIL.coos().set(0);
/*     */ 
/*     */     
/* 108 */     for (COORDINATE c : a.body()) {
/* 109 */       if (a.is(c)) {
/* 110 */         GUTIL.coos().get().set(c);
/* 111 */         GUTIL.coos().inc();
/*     */       } 
/*     */     } 
/*     */     
/* 115 */     int k = GUTIL.coos().getI();
/*     */     
/* 117 */     for (int i = 0; i < k; i++) {
/* 118 */       COORDINATEE cOORDINATEE = GUTIL.coos().set(i);
/* 119 */       (SETT.ROOMS()).map.replace(cOORDINATEE.x() + cOORDINATEE.y() * SETT.TWIDTH, o, this.ins);
/* 120 */       this.ins.setP(cOORDINATEE.x(), cOORDINATEE.y());
/*     */     } 
/* 122 */     wrap.done();
/*     */   }
/*     */ 
/*     */   
/*     */   public MAP_SETTER set(int tile) {
/* 127 */     this.ins.set(tile % SETT.TWIDTH, tile / SETT.TWIDTH);
/* 128 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public MAP_SETTER set(int tx, int ty) {
/* 133 */     this.ins.set(tx, ty);
/* 134 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void replaceAndClear(Room o) {
/* 140 */     for (COORDINATE c : this.ins.body) {
/* 141 */       if (this.ins.is(c)) {
/* 142 */         (SETT.ROOMS()).map.replace(c.x() + c.y() * SETT.TWIDTH, this.ins, o);
/*     */       }
/*     */     } 
/* 145 */     clear();
/*     */   }
/*     */ 
/*     */   
/*     */   public void clear() {
/* 150 */     (SETT.ROOMS()).fData.clear(mx(), my(), this.ins);
/* 151 */     if (this.lastUser != null) {
/* 152 */       for (COORDINATE c : this.ins.body) {
/* 153 */         if (this.ins.is(c)) {
/* 154 */           (SETT.ROOMS()).map.clear(c.x() + c.y() * SETT.TWIDTH, this.ins);
/* 155 */           if (this.removeFloor || ConstructionData.dFloored.is((SETT.ROOMS()).data.get(c.x(), c.y()), 1)) {
/* 156 */             (SETT.FLOOR()).clearer.clear(c);
/*     */           }
/*     */         } 
/*     */       } 
/*     */     }
/* 161 */     this.lastUser = null;
/* 162 */     this.ins.area = 0;
/* 163 */     this.ins.body.setDim(0.0D).moveX1Y1(-1.0D, -1.0D);
/* 164 */     this.ins.mx = -1;
/* 165 */     this.ins.my = -1;
/*     */   }
/*     */ 
/*     */   
/*     */   public void clearAndUpdate() {
/* 170 */     (SETT.ROOMS()).fData.clear(mx(), my(), this.ins);
/*     */     
/* 172 */     if (this.lastUser != null) {
/* 173 */       for (COORDINATE c : this.ins.body) {
/* 174 */         if (this.ins.is(c)) {
/* 175 */           (SETT.ROOMS()).map.clear(c.x() + c.y() * SETT.TWIDTH, this.ins);
/* 176 */           if (this.removeFloor || ConstructionData.dFloored.is((SETT.ROOMS()).data.get(c.x(), c.y()), 1)) {
/* 177 */             (SETT.FLOOR()).clearer.clear(c);
/*     */           }
/*     */         } 
/*     */       } 
/*     */     }
/* 182 */     this.lastUser = null;
/* 183 */     this.ins.area = 0;
/* 184 */     this.ins.body.setDim(0.0D).moveX1Y1(-1.0D, -1.0D);
/* 185 */     this.ins.mx = -1;
/* 186 */     this.ins.my = -1;
/*     */   }
/*     */   
/*     */   public Room.RoomInstanceImp room() {
/* 190 */     return this.ins;
/*     */   }
/*     */   
/*     */   public int mx() {
/* 194 */     return this.ins.mx;
/*     */   }
/*     */   
/*     */   public int my() {
/* 198 */     return this.ins.my;
/*     */   }
/*     */   
/*     */   private void error() {
/* 202 */     if (this.lastUser != null) {
/* 203 */       byte b; int i; StackTraceElement[] arrayOfStackTraceElement; for (i = (arrayOfStackTraceElement = this.els).length, b = 0; b < i; ) { StackTraceElement e = arrayOfStackTraceElement[b];
/* 204 */         System.err.println(e); b++; }
/*     */       
/* 206 */       throw new RuntimeException("In use by: " + String.valueOf(this.lastUser));
/*     */     } 
/*     */     
/* 209 */     throw new RuntimeException();
/*     */   }
/*     */   
/*     */   private static class Instance
/*     */     extends Room.RoomInstanceImp
/*     */   {
/* 215 */     private int area = 0;
/* 216 */     private Rec body = new Rec();
/*     */     
/*     */     private short mx;
/*     */     
/*     */     private short my;
/*     */     
/*     */     private static final long serialVersionUID = 1L;
/*     */     
/*     */     protected Instance(ROOMS m, RoomBlueprint p) {
/* 225 */       super(m, p, true);
/*     */     }
/*     */ 
/*     */     
/*     */     void setP(int tx, int ty) {
/* 230 */       if (this.area == 0) {
/* 231 */         this.mx = (short)tx;
/* 232 */         this.my = (short)ty;
/* 233 */         this.body.setDim(1.0D).moveX1Y1(tx, ty);
/*     */       } else {
/* 235 */         this.body.unify(tx, ty);
/*     */       } 
/* 237 */       this.area++;
/*     */     }
/*     */ 
/*     */     
/*     */     void set(int tx, int ty) {
/* 242 */       setP(tx, ty);
/* 243 */       (SETT.ROOMS()).map.set(tx + ty * SETT.TWIDTH, this);
/*     */     }
/*     */ 
/*     */     
/*     */     public int area() {
/* 248 */       return this.area;
/*     */     }
/*     */ 
/*     */     
/*     */     public RECTANGLE body() {
/* 253 */       return (RECTANGLE)this.body;
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean is(int tile) {
/* 258 */       return ((SETT.ROOMS()).map.indexGetter.get(tile) == this.roomI);
/*     */     }
/*     */ 
/*     */     
/*     */     protected boolean render(Renderer r, ShadowBatch shadowBatch, RenderData.RenderIterator i) {
/* 263 */       (SETT.ROOMS()).tmpArea.error();
/* 264 */       return false;
/*     */     }
/*     */ 
/*     */     
/*     */     public CharSequence name(int tx, int ty) {
/* 269 */       return "should never be";
/*     */     }
/*     */ 
/*     */     
/*     */     protected AVAILABILITY getAvailability(int tile) {
/* 274 */       return null;
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean destroyTileCan(int tx, int ty) {
/* 279 */       (SETT.ROOMS()).tmpArea.error();
/* 280 */       return false;
/*     */     }
/*     */ 
/*     */     
/*     */     public ROOM_DEGRADER degrader(int tx, int ty) {
/* 285 */       return null;
/*     */     }
/*     */ 
/*     */     
/*     */     public int mX() {
/* 290 */       return this.mx;
/*     */     }
/*     */ 
/*     */     
/*     */     public int mY() {
/* 295 */       return this.my;
/*     */     }
/*     */ 
/*     */     
/*     */     public SPRITE icon() {
/* 300 */       (SETT.ROOMS()).tmpArea.error();
/* 301 */       return null;
/*     */     }
/*     */ 
/*     */     
/*     */     public int resAmount(int ri, int upgrade) {
/* 306 */       return 0;
/*     */     }
/*     */ 
/*     */     
/*     */     public Furnisher constructor() {
/* 311 */       return (SETT.ROOMS()).tmpArea.cons;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void destroyTile(int tx, int ty) {
/* 318 */       (SETT.ROOMS()).tmpArea.error();
/*     */     }
/*     */ 
/*     */     
/*     */     public TmpArea remove(int tx, int ty, boolean scatter, Object user, boolean forced) {
/* 323 */       (SETT.ROOMS()).tmpArea.error();
/* 324 */       return null;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public RECTANGLE body() {
/* 331 */     return this.ins.body();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean is(int tile) {
/* 336 */     return this.ins.is(tile);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean is(int tx, int ty) {
/* 341 */     return this.ins.is(tx, ty);
/*     */   }
/*     */ 
/*     */   
/*     */   public int area() {
/* 346 */     return this.ins.area;
/*     */   }
/*     */ 
/*     */   
/*     */   public int index() {
/* 351 */     return this.ins.index();
/*     */   }
/*     */ 
/*     */   
/*     */   public int mX() {
/* 356 */     return this.ins.mX();
/*     */   }
/*     */ 
/*     */   
/*     */   public int mY() {
/* 361 */     return this.ins.mY();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\main\TmpArea.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */