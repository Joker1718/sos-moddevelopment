/*     */ package settlement.room.main.util;
/*     */ 
/*     */ import settlement.main.SETT;
/*     */ import settlement.room.main.ROOMA;
/*     */ import settlement.room.main.Room;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.datatypes.Rec;
/*     */ 
/*     */ public class RoomAreaWrapper
/*     */ {
/*  12 */   private Rec body = new Rec();
/*     */   
/*     */   private Room room;
/*     */   
/*     */   private int mx;
/*     */   
/*     */   private int my;
/*     */   private int area;
/*     */   private boolean used;
/*     */   private ROOMA a;
/*     */   
/*     */   public ROOMA init(Room r, int x, int y) {
/*  24 */     use();
/*  25 */     if (r instanceof ROOMA)
/*  26 */       return (ROOMA)r; 
/*  27 */     if (this.room == r) this.a.is(x, y); 
/*  28 */     this.room = r;
/*  29 */     this.mx = r.mX(x, y);
/*  30 */     this.my = r.mY(x, y);
/*  31 */     this.body.moveX1Y1(r.x1(this.mx, this.my), r.y1(this.mx, this.my));
/*  32 */     this.body.setDim(r.width(this.mx, this.my), r.height(this.mx, this.my));
/*  33 */     this.area = r.area(this.mx, this.my);
/*     */     
/*  35 */     return this.a;
/*     */   }
/*     */   
/*     */   private void use() {
/*  39 */     if (this.used)
/*     */     {
/*     */       
/*  42 */       throw new RuntimeException();
/*     */     }
/*  44 */     this.used = true;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean changedAndInit(Room r, int x, int y) {
/*  49 */     use();
/*  50 */     if (this.room != r || !this.a.is(x, y)) {
/*     */       
/*  52 */       this.room = r;
/*  53 */       this.mx = r.mX(x, y);
/*  54 */       this.my = r.mY(x, y);
/*  55 */       this.body.moveX1Y1(r.x1(this.mx, this.my), r.y1(this.mx, this.my));
/*  56 */       this.body.setDim(r.width(this.mx, this.my), r.height(this.mx, this.my));
/*  57 */       this.area = r.area(this.mx, this.my);
/*  58 */       return true;
/*     */     } 
/*  60 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public ROOMA init(Room r, COORDINATE c) {
/*  65 */     return init(r, c.x(), c.y());
/*     */   }
/*     */   
/*     */   public ROOMA area() {
/*  69 */     return this.a;
/*     */   }
/*     */   
/*     */   public void done() {
/*  73 */     this.used = false;
/*     */   }
/*     */   public RoomAreaWrapper() {
/*  76 */     this.a = new ROOMA()
/*     */       {
/*     */         public RECTANGLE body()
/*     */         {
/*  80 */           return (RECTANGLE)RoomAreaWrapper.this.body;
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean is(int tile) {
/*  85 */           return is(tile % SETT.TWIDTH, tile / SETT.TWIDTH);
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean is(int tx, int ty) {
/*  90 */           return (RoomAreaWrapper.this.room != null && (SETT.ROOMS()).map.get(tx, ty) == RoomAreaWrapper.this.room && RoomAreaWrapper.this.room.isSame(RoomAreaWrapper.this.mx, RoomAreaWrapper.this.my, tx, ty));
/*     */         }
/*     */ 
/*     */         
/*     */         public int area() {
/*  95 */           return RoomAreaWrapper.this.area;
/*     */         }
/*     */ 
/*     */         
/*     */         public int index() {
/* 100 */           return RoomAreaWrapper.this.room.index();
/*     */         }
/*     */ 
/*     */         
/*     */         public int mX() {
/* 105 */           return RoomAreaWrapper.this.mx;
/*     */         }
/*     */ 
/*     */         
/*     */         public int mY() {
/* 110 */           return RoomAreaWrapper.this.my;
/*     */         }
/*     */       };
/*     */   }
/*     */   public void clear() {
/* 115 */     this.room = null;
/*     */   }
/*     */   public static class RoomWrap implements ROOMA { private Rec body;
/*     */     
/*     */     public RoomWrap() {
/* 120 */       this.body = new Rec();
/*     */     }
/*     */     private Room room; private int mx; private int my;
/*     */     private int area;
/*     */     
/*     */     public boolean init(Room r, int x, int y) {
/* 126 */       if (this.room != r || !is(x, y)) {
/* 127 */         this.room = r;
/* 128 */         this.mx = r.mX(x, y);
/* 129 */         this.my = r.mY(x, y);
/* 130 */         this.body.moveX1Y1(r.x1(this.mx, this.my), r.y1(this.mx, this.my));
/* 131 */         this.body.setDim(r.width(this.mx, this.my), r.height(this.mx, this.my));
/* 132 */         this.area = r.area(this.mx, this.my);
/* 133 */         return true;
/*     */       } 
/* 135 */       return false;
/*     */     }
/*     */ 
/*     */     
/*     */     public RECTANGLE body() {
/* 140 */       return (RECTANGLE)this.body;
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean is(int tile) {
/* 145 */       return is(tile % SETT.TWIDTH, tile / SETT.TWIDTH);
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean is(int tx, int ty) {
/* 150 */       return ((SETT.ROOMS()).map.get(tx, ty) == this.room && this.room.isSame(this.mx, this.my, tx, ty));
/*     */     }
/*     */ 
/*     */     
/*     */     public int area() {
/* 155 */       return this.area;
/*     */     }
/*     */ 
/*     */     
/*     */     public int index() {
/* 160 */       return this.room.index();
/*     */     }
/*     */ 
/*     */     
/*     */     public int mX() {
/* 165 */       return this.mx;
/*     */     }
/*     */ 
/*     */     
/*     */     public int mY() {
/* 170 */       return this.my;
/*     */     } }
/*     */ 
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\mai\\util\RoomAreaWrapper.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */