/*     */ package settlement.room.infra.logistics;
/*     */ 
/*     */ import init.resources.RBIT;
/*     */ import java.io.IOException;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.io.Serializable;
/*     */ import settlement.main.SETT;
/*     */ import settlement.misc.util.RESOURCE_TILE;
/*     */ import settlement.misc.util.TILE_STORAGE;
/*     */ import settlement.room.main.Room;
/*     */ import settlement.room.main.RoomInstance;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.Coo;
/*     */ import util.text.D;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class MoveOrderPull
/*     */   implements Serializable
/*     */ {
/*  23 */   private static CharSequence ¤¤RoomInvalid = "The room to pull from is invalid";
/*  24 */   private static CharSequence ¤¤noRes = "No resources have been selected.";
/*  25 */   private static CharSequence ¤¤noResBoth = "Neither the source or destination room resources match the selected resources.";
/*  26 */   private static CharSequence ¤¤noResSource = "The source room does not have any crates available of the selected resources.";
/*  27 */   private static CharSequence ¤¤noResDest = "The destination room's resources doesn't match the selected resources.";
/*  28 */   private static CharSequence ¤¤noResSourceA = "The source room does not have any resources available to be pulled.";
/*  29 */   private static CharSequence ¤¤noResDestA = "The destination room does not have any crates available of the the selected resources.";
/*  30 */   private static CharSequence ¤¤noResBothA = "Neither the source nor destination room have crates available.";
/*  31 */   private static CharSequence ¤¤cycle = "The order is cyclic. Resources will be moved back and forth.";
/*     */   static {
/*  33 */     D.ts(MoveOrderPull.class);
/*     */   }
/*  35 */   private static final RBIT.RBITImp tmp = new RBIT.RBITImp();
/*  36 */   private final Coo coo = new Coo();
/*  37 */   public final RBIT.RBITImp resbits = new RBIT.RBITImp();
/*  38 */   public byte cooldown = 0;
/*     */   
/*     */   public byte pullLimit;
/*     */   
/*     */   private short lsx;
/*     */   private short lsy;
/*     */   private short ldx;
/*     */   private short ldy;
/*     */   private static final long serialVersionUID = 1L;
/*     */   
/*     */   public MoveOrderPull(COORDINATE coo, RBIT res) {
/*  49 */     this.coo.set(coo.x(), coo.y());
/*  50 */     this.resbits.clearSet(res);
/*     */   }
/*     */   
/*     */   public MoveOrderPull(RoomInstance dest, RBIT res) {
/*  54 */     this.coo.set(dest.mX(), dest.mY());
/*  55 */     this.resbits.clearSet(res);
/*     */   }
/*     */   
/*     */   private void readObject(ObjectInputStream ois) throws ClassNotFoundException, IOException {
/*  59 */     ois.defaultReadObject();
/*     */   }
/*     */   
/*     */   public CharSequence problem(MoveOrderPullInstance ins) {
/*  63 */     return problem(source(), ins, (RBIT)this.resbits);
/*     */   }
/*     */   
/*     */   public static CharSequence problem(MoveJob.ROOM_MOVE_SOURCE source, MoveOrderPullInstance ins, RBIT bits) {
/*  67 */     if (source == null) {
/*  68 */       return ¤¤RoomInvalid;
/*     */     }
/*  70 */     if (bits.isClear()) {
/*  71 */       return ¤¤noRes;
/*     */     }
/*  73 */     if (!source.moveCapacity().has(bits)) {
/*  74 */       return ¤¤noResSource;
/*     */     }
/*  76 */     if (!ins.moveOrderPullAccepted().has(bits)) {
/*  77 */       return ¤¤noResDest;
/*     */     }
/*     */     
/*  80 */     tmp.clearSet(bits).and(source.moveCapacity()).and(ins.moveOrderPullAccepted());
/*     */     
/*  82 */     if (tmp.isClear()) {
/*  83 */       return ¤¤noResBoth;
/*     */     }
/*  85 */     return null;
/*     */   }
/*     */   
/*     */   public CharSequence warning(MoveOrderPullInstance ins) {
/*  89 */     CharSequence p = problem(ins);
/*  90 */     if (p != null) {
/*  91 */       return p;
/*     */     }
/*  93 */     MoveJob.ROOM_MOVE_SOURCE source = source();
/*     */     
/*  95 */     tmp.clear();
/*  96 */     tmp.or(source.moveCapacity());
/*  97 */     tmp.and((RBIT)this.resbits);
/*     */ 
/*     */ 
/*     */     
/* 101 */     if (tmp.isClear()) {
/* 102 */       return ¤¤noResSource;
/*     */     }
/*     */     
/* 105 */     tmp.and(source.sourceAmountMask());
/*     */     
/* 107 */     if (tmp.isClear()) {
/* 108 */       return ¤¤noResSourceA;
/*     */     }
/*     */     
/* 111 */     RBIT bb = ins.moveOrderPullAvailable();
/* 112 */     if (!bb.has((RBIT)this.resbits)) {
/* 113 */       return ¤¤noResDestA;
/*     */     }
/*     */     
/* 116 */     tmp.and(bb);
/*     */     
/* 118 */     if (tmp.isClear()) {
/* 119 */       return ¤¤noResBothA;
/*     */     }
/*     */     
/* 122 */     RESOURCE_TILE t = source.sourceCrate((RBIT)tmp, ins.moveMinAmount(), this.lsx, this.lsy, this.pullLimit / 100.0D);
/* 123 */     if (t == null) {
/* 124 */       return ¤¤noResSourceA;
/*     */     }
/* 126 */     this.lsx = (short)t.x();
/* 127 */     this.lsy = (short)t.y();
/*     */ 
/*     */     
/* 130 */     RoomInstance isource = (RoomInstance)source;
/*     */     
/* 132 */     if (isource instanceof MoveOrderPullInstance) {
/* 133 */       MoveOrderPullInstance oo = (MoveOrderPullInstance)isource; byte b; int i; MoveOrderPull[] arrayOfMoveOrderPull;
/* 134 */       for (i = (arrayOfMoveOrderPull = oo.moveOrdersPull()).length, b = 0; b < i; ) { MoveOrderPull o = arrayOfMoveOrderPull[b];
/* 135 */         if (o != null && o.source() == ins)
/*     */         {
/* 137 */           if (ins.moveOrderPullAccepted().has(oo.moveOrderPullAccepted()) && 
/* 138 */             this.resbits.has(oo.moveOrderPullAccepted()) && o.resbits.has((RBIT)this.resbits)) {
/* 139 */             return ¤¤cycle;
/*     */           }
/*     */         }
/*     */         
/*     */         b++; }
/*     */     
/*     */     } 
/* 146 */     if (ins instanceof MoveOrderPush.MoveOrderPushInstance) {
/* 147 */       MoveOrderPush.MoveOrderPushInstance pi = (MoveOrderPush.MoveOrderPushInstance)ins; byte b; int i; MoveOrderPush[] arrayOfMoveOrderPush;
/* 148 */       for (i = (arrayOfMoveOrderPush = pi.moveOrdersPush()).length, b = 0; b < i; ) { MoveOrderPush po = arrayOfMoveOrderPush[b];
/* 149 */         if (po != null) {
/* 150 */           byte b1; int j; MoveOrderPull[] arrayOfMoveOrderPull; for (j = (arrayOfMoveOrderPull = ins.moveOrdersPull()).length, b1 = 0; b1 < j; ) { MoveOrderPull puo = arrayOfMoveOrderPull[b1];
/* 151 */             if (ins.moveOrderPullAccepted().has(puo.source().moveCapacity())) {
/* 152 */               return ¤¤cycle;
/*     */             }
/*     */             b1++; }
/*     */         
/*     */         } 
/*     */         b++; }
/*     */     
/*     */     } 
/* 160 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public void destSet(RoomInstance dest) {
/* 165 */     this.coo.set(dest.mX(), dest.mY());
/*     */   }
/*     */   
/*     */   public COORDINATE destCoo() {
/* 169 */     return (COORDINATE)this.coo;
/*     */   }
/*     */   
/*     */   public MoveJob.ROOM_MOVE_SOURCE source() {
/* 173 */     Room r = (Room)(SETT.ROOMS()).map.get((COORDINATE)this.coo);
/* 174 */     if (r != null && r instanceof MoveJob.ROOM_MOVE_SOURCE) {
/* 175 */       return (MoveJob.ROOM_MOVE_SOURCE)r;
/*     */     }
/* 177 */     return null;
/*     */   }
/*     */   
/*     */   public RoomInstance sourceI() {
/* 181 */     Room r = (Room)(SETT.ROOMS()).map.get((COORDINATE)this.coo);
/* 182 */     if (r != null && r instanceof MoveJob.ROOM_MOVE_SOURCE) {
/* 183 */       return (RoomInstance)r;
/*     */     }
/* 185 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public MoveJob job(MoveJob.ROOM_MOVE_DEST dest, int carryMin, int carryMax) {
/* 190 */     if (carryMin <= 0) {
/* 191 */       throw new RuntimeException();
/*     */     }
/* 193 */     if (carryMax <= 0) {
/* 194 */       throw new RuntimeException();
/*     */     }
/* 196 */     carryMin = Math.min(carryMin, carryMax);
/*     */     
/* 198 */     MoveJob.ROOM_MOVE_SOURCE source = source();
/* 199 */     if (source == null) {
/* 200 */       return null;
/*     */     }
/* 202 */     RBIT fetchBits = dest.destSpaceMask();
/* 203 */     if (!source().sourceAmountMask().has(fetchBits))
/* 204 */       return null; 
/* 205 */     tmp.clear();
/* 206 */     tmp.or(fetchBits);
/* 207 */     tmp.and((RBIT)this.resbits);
/*     */     
/* 209 */     if (tmp.isClear()) {
/* 210 */       return null;
/*     */     }
/* 212 */     RESOURCE_TILE t = source.sourceCrate((RBIT)tmp, carryMin, this.lsx, this.lsy, this.pullLimit / 100.0D);
/*     */     
/* 214 */     if (t == null)
/* 215 */       return null; 
/* 216 */     if (t.resource() == null)
/* 217 */       throw new RuntimeException(); 
/* 218 */     if (!(t.resource()).bit.has((RBIT)tmp)) {
/* 219 */       throw new RuntimeException();
/*     */     }
/* 221 */     int am = Math.min(carryMax, t.reservable());
/* 222 */     if (am <= 0)
/* 223 */       throw new RuntimeException(); 
/* 224 */     this.lsx = (short)t.x();
/* 225 */     this.lsy = (short)t.y();
/* 226 */     MoveJob j = MoveJob.TMP;
/* 227 */     j.res = t.resource();
/*     */     
/* 229 */     j.source.set((COORDINATE)t);
/* 230 */     j.stored = t.isStorage();
/* 231 */     j.prio = t.isPrio();
/* 232 */     TILE_STORAGE st = dest.destCrate(j.res.bit, carryMin, this.ldx, this.ldy);
/* 233 */     if (st == null)
/* 234 */       return null; 
/* 235 */     am = Math.min(am, st.storageReservable());
/*     */     
/* 237 */     if (am <= 0) {
/* 238 */       throw new RuntimeException("" + st.storageReservable() + " " + st.storageReservable());
/*     */     }
/* 240 */     j.maxAm = am;
/* 241 */     j.dest.set(st.x(), st.y());
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 247 */     this.ldx = (short)st.x();
/* 248 */     this.ldy = (short)st.y();
/*     */     
/* 250 */     st = ((RoomInstance)dest).storage(j.dest.x(), j.dest.y());
/*     */     
/* 252 */     if (st.resource() != j.res) {
/* 253 */       throw new RuntimeException(String.valueOf(st.resource()) + " " + String.valueOf(st.resource()));
/*     */     }
/*     */     
/* 256 */     return j;
/*     */   }
/*     */   
/*     */   public static interface MoveOrderPullInstance {
/*     */     MoveOrderPull[] moveOrdersPull();
/*     */     
/*     */     RBIT moveOrderPullAccepted();
/*     */     
/*     */     RBIT moveOrderPullAvailable();
/*     */     
/*     */     int moveMinAmount();
/*     */     
/*     */     int moveMaxRadius();
/*     */     
/*     */     void copyFrom(MoveOrderPullInstance param1MoveOrderPullInstance);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\infra\logistics\MoveOrderPull.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */