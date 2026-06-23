/*     */ package view.sett.ui.room.copy;
/*     */ 
/*     */ import settlement.main.SETT;
/*     */ import settlement.room.main.ROOMA;
/*     */ import settlement.room.main.Room;
/*     */ import settlement.room.main.util.RoomAreaWrapper;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.datatypes.Rec;
/*     */ import snake2d.util.iterators.RECIter;
/*     */ import snake2d.util.sets.Bitmap1D;
/*     */ 
/*     */ final class RoomChecker {
/*     */   private final Dest dest;
/*  15 */   private final Bitmap1D placableBits = new Bitmap1D(SETT.TAREA, false);
/*  16 */   private Rec box = new Rec();
/*  17 */   private final RECIter iter = new RECIter((RECTANGLE)this.box);
/*  18 */   private static final RoomAreaWrapper wrap = new RoomAreaWrapper();
/*     */   
/*     */   RoomChecker(Dest dest) {
/*  21 */     this.dest = dest;
/*     */   }
/*     */   
/*     */   void init() {
/*  25 */     this.placableBits.clear();
/*  26 */     for (COORDINATE c : this.dest.body()) {
/*  27 */       if (!this.placableBits.get(c.x() + c.y() * SETT.TWIDTH) && isBlocked(c.x(), c.y())) {
/*  28 */         markRoom(c);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   private void markRoom(COORDINATE coo) {
/*  34 */     setBox(coo.x(), coo.y());
/*  35 */     COORDINATE source = this.dest.transform(coo.x(), coo.y());
/*  36 */     Room room = (Room)(SETT.ROOMS()).map.get(source);
/*  37 */     ROOMA r = wrap.init(room, source.x(), source.y());
/*  38 */     for (COORDINATE c : this.iter) {
/*  39 */       COORDINATE s = this.dest.transform(c.x(), c.y());
/*  40 */       if (r.is(s)) {
/*  41 */         this.placableBits.set(c.x() + c.y() * SETT.TWIDTH, true);
/*     */       }
/*     */     } 
/*  44 */     wrap.done();
/*     */   }
/*     */   
/*     */   private void setBox(int newX, int newY) {
/*  48 */     COORDINATE s = this.dest.transform(newX, newY);
/*     */     
/*  50 */     Room room = (SETT.ROOMS()).map.get(s.x(), s.y());
/*  51 */     ROOMA r = wrap.init(room, s.x(), s.y());
/*     */     
/*  53 */     int dx = s.x() - r.body().cX();
/*  54 */     int dy = s.y() - r.body().cY();
/*  55 */     int w = r.body().width();
/*  56 */     int h = r.body().height();
/*  57 */     for (int i = 0; i < 4 - this.dest.rot(); i++) {
/*  58 */       int k = dx;
/*  59 */       dx = dy;
/*  60 */       dy = -k;
/*  61 */       k = w;
/*  62 */       w = h;
/*  63 */       h = k;
/*     */     } 
/*     */     
/*  66 */     int x1 = newX - dx - w / 2;
/*  67 */     int y1 = newY - dy - h / 2;
/*  68 */     this.box.setDim(w, h);
/*  69 */     this.box.moveX1Y1(x1, y1);
/*  70 */     wrap.done();
/*     */   }
/*     */   
/*     */   public boolean place(int tx, int ty) {
/*  74 */     COORDINATE s = this.dest.transform(tx, ty);
/*     */     
/*  76 */     Room room = (SETT.ROOMS()).map.get(s.x(), s.y());
/*  77 */     if (room == null) {
/*  78 */       return false;
/*     */     }
/*  80 */     if (!isBlocked(tx, ty) && !isPartOfBlocked(tx, ty)) {
/*     */       
/*  82 */       ROOMA r = wrap.init(room, s.x(), s.y());
/*  83 */       wrap.done();
/*  84 */       if (r == null) {
/*  85 */         return true;
/*     */       }
/*  87 */       if (r.mX() == s.x() && r.mY() == s.y()) {
/*     */         
/*  89 */         for (COORDINATE c : r.body()) {
/*     */ 
/*     */ 
/*     */           
/*  93 */           if (r.is(c)) {
/*  94 */             int x = c.x() - r.mX() + tx;
/*  95 */             int y = c.y() - r.mY() + ty;
/*     */             
/*  97 */             if (this.dest.sourceIs(x, y))
/*     */             {
/*  99 */               return true;
/*     */             }
/*     */           } 
/*     */         } 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 107 */         s = this.dest.transform(tx, ty);
/*     */         
/* 109 */         int nx = s.x() - r.body().cX();
/* 110 */         int ny = s.y() - r.body().cY();
/* 111 */         for (int i = 0; i < 4 - this.dest.rot(); i++) {
/* 112 */           int k = nx;
/* 113 */           nx = ny;
/* 114 */           ny = -k;
/*     */         } 
/* 116 */         tx -= nx;
/* 117 */         ty -= ny;
/* 118 */         (SETT.ROOMS()).copy.copier.copy(r.mX(), r.mY(), tx, ty, this.dest.rot());
/*     */       } 
/*     */ 
/*     */       
/* 122 */       return true;
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 128 */     return true;
/*     */   }
/*     */   
/*     */   public boolean isBlocked(int dx, int dy) {
/* 132 */     COORDINATE s = this.dest.transform(dx, dy);
/* 133 */     return ((SETT.ROOMS()).copy.copier.canCopy(s.x(), s.y()) && !(SETT.ROOMS()).copy.copier.isPlacable(s.x(), s.y(), dx, dy));
/*     */   }
/*     */   
/*     */   public boolean isPartOfBlocked(int dx, int dy) {
/* 137 */     return this.placableBits.get(dx + dy * SETT.TWIDTH);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\room\copy\RoomChecker.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */