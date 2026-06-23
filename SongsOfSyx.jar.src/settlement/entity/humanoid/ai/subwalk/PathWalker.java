/*     */ package settlement.entity.humanoid.ai.subwalk;
/*     */ 
/*     */ import game.GAME;
/*     */ import settlement.entity.humanoid.HEvent;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.entity.humanoid.ai.main.AI;
/*     */ import settlement.entity.humanoid.ai.main.AIManager;
/*     */ import settlement.entity.humanoid.ai.main.AISTATE;
/*     */ import settlement.entity.humanoid.ai.main.AISTATES;
/*     */ import settlement.entity.humanoid.ai.main.AISUB;
/*     */ import snake2d.util.rnd.RND;
/*     */ 
/*     */ abstract class PathWalker extends AISUB.Resumable {
/*     */   protected final AISTATES.WALK_DEST state;
/*     */   private final AISUB.Resumable.Resumer next;
/*     */   final AISUB.Resumable.Resumer moveToEdge;
/*     */   final AISUB.Resumable.Resumer wait;
/*     */   private final AISUB.Resumable.Resumer stop;
/*     */   final AISUB.Resumable.Resumer failure;
/*     */   
/*  21 */   PathWalker(String key, AISTATES.WALK_DEST state, CharSequence name) { super(key + "Walker", name);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  49 */     this.next = new AISUB.Resumable.Resumer(this)
/*     */       {
/*     */         public AISTATE res(Humanoid a, AIManager d)
/*     */         {
/*  53 */           if (d.path.isDest()) {
/*  54 */             a.speed.turn2((BODY_HOLDER)a, ((d.path.destX() << 6) + 32), ((d.path.destY() << 6) + 32));
/*  55 */             return PathWalker.this.setLast(a, d);
/*     */           } 
/*     */           
/*  58 */           d.path.setNext();
/*  59 */           if (!d.path.isSuccessful()) {
/*  60 */             GAME.Notify("no " + String.valueOf(a.physics.tileC()) + " " + d.path.destX() + " " + d.path.destY());
/*  61 */             return PathWalker.this.failure.set(a, d);
/*     */           } 
/*  63 */           d.subPathByte2 = (byte)(d.subPathByte2 + 1);
/*  64 */           if (d.subPathByte2 > 4) {
/*  65 */             d.subPathByte2 = 0;
/*  66 */             if (PathWalker.this.hasFailed(a, d)) {
/*  67 */               a.speed.magnitudeInit(0.0D);
/*  68 */               return PathWalker.this.failure.set(a, d);
/*     */             } 
/*     */           } 
/*     */           
/*  72 */           return PathWalker.this.state.path(a, d);
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean success(Humanoid a, AIManager d) {
/*  77 */           return true;
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public void can(Humanoid a, AIManager d) {
/*  83 */           PathWalker.this.abort(a, d);
/*     */         }
/*     */ 
/*     */         
/*     */         public AISTATE setAction(Humanoid a, AIManager d) {
/*  88 */           return res(a, d);
/*     */         }
/*     */       };
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  95 */     this.moveToEdge = new AISUB.Resumable.Resumer(this)
/*     */       {
/*     */         public AISTATE res(Humanoid a, AIManager d)
/*     */         {
/*  99 */           int dy = d.path.destY() * 64 + 32 - a.body().cY();
/* 100 */           int dx = d.path.destX() * 64 + 32 - a.body().cX();
/* 101 */           a.speed.setDirCurrent(DIR.get(dx, dy));
/* 102 */           return PathWalker.this.wait.set(a, d);
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean success(Humanoid a, AIManager d) {
/* 107 */           return true;
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public AISTATE setAction(Humanoid a, AIManager d) {
/* 113 */           int x2 = d.path.getSettCX();
/* 114 */           int y2 = d.path.getSettCY();
/* 115 */           int dd = (64 - a.body().width() - 2) / 2;
/* 116 */           if (d.path.isFull()) {
/* 117 */             if (dd > 3)
/* 118 */               dd = 3; 
/* 119 */             x2 += RND.rInt0(dd);
/* 120 */             y2 += RND.rInt0(dd);
/*     */           } else {
/*     */             
/* 123 */             int dy = d.path.destY() - d.path.y();
/* 124 */             int dx = d.path.destX() - d.path.x();
/* 125 */             x2 += dx * dd;
/* 126 */             y2 += dy * dd;
/*     */           } 
/*     */           
/* 129 */           return (AI.STATES()).WALK2.free(a, d, x2, y2);
/*     */         }
/*     */ 
/*     */         
/*     */         public void can(Humanoid a, AIManager d) {
/* 134 */           PathWalker.this.abort(a, d);
/*     */         }
/*     */       };
/*     */     
/* 138 */     this.wait = new AISUB.Resumable.Resumer(this)
/*     */       {
/*     */         public AISTATE res(Humanoid a, AIManager d)
/*     */         {
/* 142 */           if (PathWalker.this.hasFailed(a, d) || !d.path.isSuccessful()) {
/* 143 */             return PathWalker.this.failure.set(a, d);
/*     */           }
/* 145 */           PathWalker.this.arrive(a, d);
/* 146 */           return null;
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean success(Humanoid a, AIManager d) {
/* 151 */           return true;
/*     */         }
/*     */ 
/*     */         
/*     */         public AISTATE setAction(Humanoid a, AIManager d) {
/* 156 */           a.speed.magnitudeInit(0.0D);
/* 157 */           return (AI.STATES()).STAND.activate(a, d, 0.5D);
/*     */         }
/*     */         
/*     */         public void can(Humanoid a, AIManager d) {
/* 161 */           PathWalker.this.abort(a, d);
/*     */         }
/*     */       };
/*     */     
/* 165 */     this.stop = new AISUB.Resumable.Resumer(this)
/*     */       {
/*     */         public AISTATE res(Humanoid a, AIManager d)
/*     */         {
/* 169 */           if (PathWalker.this.hasFailed(a, d)) {
/* 170 */             return PathWalker.this.failure.set(a, d);
/*     */           }
/* 172 */           return PathWalker.this.next.set(a, d);
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean success(Humanoid a, AIManager d) {
/* 177 */           return true;
/*     */         }
/*     */ 
/*     */         
/*     */         public AISTATE setAction(Humanoid a, AIManager d) {
/* 182 */           return (AI.STATES()).STOP.activate(a, d);
/*     */         }
/*     */         
/*     */         public void can(Humanoid a, AIManager d) {
/* 186 */           PathWalker.this.abort(a, d);
/*     */         }
/*     */       };
/*     */ 
/*     */     
/* 191 */     this.failure = new AISUB.Resumable.Resumer(this)
/*     */       {
/*     */ 
/*     */         
/*     */         public AISTATE res(Humanoid a, AIManager d)
/*     */         {
/* 197 */           return null;
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean success(Humanoid a, AIManager d) {
/* 202 */           return false;
/*     */         }
/*     */         
/*     */         public AISTATE setAction(Humanoid a, AIManager d)
/*     */         {
/* 207 */           a.speed.magnitudeInit(0.0D);
/* 208 */           PathWalker.this.abort(a, d);
/* 209 */           return (AI.STATES()).STAND.activate(a, d, 0.10000000149011612D);
/*     */         }
/*     */       };
/*     */     this.state = state; }
/*     */    protected PathWalker(String key, String name) {
/*     */     this(key + "Walker", (AI.STATES()).WALK2, name);
/*     */   }
/* 216 */   public void cancel(Humanoid a, AIManager d) { super.cancel(a, d); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final AISTATE resumeInterrupted(Humanoid a, AIManager d, HEvent event) {
/* 223 */     d.subPathByte2 = 0;
/*     */     
/* 225 */     if (event == HEvent.COLLISION_TILE) {
/* 226 */       return null;
/*     */     }
/* 228 */     if (d.path().isFull() && !(SETT.PATH()).connectivity.is(d.path().destX(), d.path().destY())) {
/* 229 */       return null;
/*     */     }
/* 231 */     if (hasFailed(a, d) || !d.path.resume(a.physics.tileC(), a.body())) {
/* 232 */       return null;
/*     */     }
/* 234 */     return init(a, d);
/*     */   } public AISTATE init(Humanoid a, AIManager d) { if (a.speed.magnitude() > 0.0D)
/*     */       return this.stop.set(a, d);  if (!d.path.isSuccessful()) {
/*     */       GAME.Notify("here!" + String.valueOf(d.path)); return this.failure.set(a, d);
/*     */     }  d.subPathByte2 = 0; AISTATE st = this.next.set(a, d); if (st == null)
/* 239 */       return this.stop.set(a, d);  return st; } public AISTATE resume(Humanoid a, AIManager d) { AISTATE s = super.resume(a, d);
/* 240 */     return s; }
/*     */ 
/*     */   
/*     */   protected AISTATE setLast(Humanoid a, AIManager d) {
/* 244 */     return this.moveToEdge.set(a, d);
/*     */   }
/*     */   
/*     */   protected abstract boolean hasFailed(Humanoid paramHumanoid, AIManager paramAIManager);
/*     */   
/*     */   protected abstract void abort(Humanoid paramHumanoid, AIManager paramAIManager);
/*     */   
/*     */   protected abstract void arrive(Humanoid paramHumanoid, AIManager paramAIManager);
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\subwalk\PathWalker.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */