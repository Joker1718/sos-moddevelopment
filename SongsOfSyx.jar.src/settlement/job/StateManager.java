/*     */ package settlement.job;
/*     */ 
/*     */ import settlement.main.SETT;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.map.MAP_OBJECT;
/*     */ import snake2d.util.sets.Bitsmap1D;
/*     */ 
/*     */ 
/*     */ final class StateManager
/*     */   implements MAP_OBJECT<StateManager.State>
/*     */ {
/*     */   private final Bitsmap1D bits;
/*     */   private static final int MAX_DISTANCE = 16;
/*     */   
/*     */   enum State
/*     */   {
/*  17 */     DORMANT, RESERVABLE, RESERVED, BLOCKED;
/*     */     
/*  19 */     static State[] all = values();
/*     */ 
/*     */     
/*     */     static {
/*     */     
/*     */     }
/*     */   }
/*     */   
/*     */   public StateManager(Bitsmap1D bits) {
/*  28 */     this.bits = bits;
/*     */   }
/*     */ 
/*     */   
/*     */   public State get(int tile) {
/*  33 */     return State.all[this.bits.get(tile)];
/*     */   }
/*     */ 
/*     */   
/*     */   public State get(int tx, int ty) {
/*  38 */     return get(tx + ty * SETT.TWIDTH);
/*     */   }
/*     */ 
/*     */   
/*     */   public void set(State value, Job job) {
/*  43 */     int tx = job.coo.x();
/*  44 */     int ty = job.coo.y();
/*     */     
/*  46 */     if (get(job.jobCoo()) == State.DORMANT && value != State.RESERVABLE) {
/*     */       return;
/*     */     }
/*     */     
/*  50 */     if (value == State.BLOCKED) {
/*  51 */       value = State.RESERVABLE;
/*     */     }
/*  53 */     if (isBlocked(tx, ty)) {
/*  54 */       value = State.BLOCKED;
/*     */     }
/*  56 */     set(value, tx, ty);
/*     */     
/*  58 */     for (int di = 0; di < DIR.ALL.size(); di++) {
/*  59 */       DIR d = (DIR)DIR.ALL.get(di);
/*  60 */       int dx = tx + d.x();
/*  61 */       int dy = ty + d.y();
/*  62 */       if ((SETT.JOBS()).getter.is(dx, dy)) {
/*  63 */         if (isBlocked(dx, dy)) {
/*  64 */           set(State.BLOCKED, dx, dy);
/*  65 */         } else if (get(dx + dy * SETT.TWIDTH) == State.BLOCKED) {
/*  66 */           set(State.RESERVABLE, dx, dy);
/*     */         } 
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/*  72 */     job.get(tx, ty);
/*     */   }
/*     */   
/*     */   private void set(State state, int tx, int ty) {
/*  76 */     int tile = tx + ty * SETT.TWIDTH;
/*  77 */     State old = get(tile);
/*     */     
/*  79 */     if (old == state) {
/*     */       return;
/*     */     }
/*  82 */     if (old == State.RESERVABLE) {
/*  83 */       (SETT.PATH()).finders.job.report((Job)(SETT.JOBS()).getter.get(tx, ty), -1);
/*     */     }
/*     */     
/*  86 */     this.bits.set(tile, state.ordinal());
/*     */     
/*  88 */     if (state == State.RESERVABLE) {
/*  89 */       (SETT.PATH()).finders.job.report((Job)(SETT.JOBS()).getter.get(tx, ty), 1);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   private boolean isBlocked(int tx, int ty) {
/*  95 */     if (!isBlockingJob(tx, ty)) {
/*  96 */       return false;
/*     */     }
/*  98 */     int depth = getDepth(tx, ty);
/*  99 */     if (depth == 16) {
/* 100 */       if ((SETT.PATH()).solidity.is(tx, ty, DIR.N)) {
/* 101 */         return false;
/*     */       }
/* 103 */       if (getDepth(tx + DIR.N.x(), ty + DIR.N.y()) < 16) {
/* 104 */         return false;
/*     */       }
/* 106 */       return true;
/*     */     } 
/*     */     
/* 109 */     for (int di = 0; di < DIR.ORTHO.size(); di++) {
/* 110 */       DIR d = (DIR)DIR.ORTHO.get(di);
/* 111 */       int dx = tx + d.x();
/* 112 */       int dy = ty + d.y();
/* 113 */       if (canBeBlocked(dx, dy) && getDepth(dx, dy) > depth) {
/* 114 */         return true;
/*     */       }
/*     */     } 
/*     */     
/* 118 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getDepth(int tx, int ty) {
/* 123 */     int depth = getDepthOrtho(tx, ty);
/* 124 */     if (depth < 16) {
/* 125 */       return depth;
/*     */     }
/*     */     
/* 128 */     for (int di = 0; di < DIR.ORTHO.size(); di++) {
/* 129 */       DIR d = (DIR)DIR.ORTHO.get(di);
/* 130 */       if (!SETT.IN_BOUNDS(tx, ty, d) || (SETT.PATH()).solidity.is(tx, ty, d)) {
/* 131 */         depth += SETT.TWIDTH;
/*     */       }
/*     */     } 
/* 134 */     return depth + getDepthNortho(tx, ty);
/*     */   }
/*     */ 
/*     */   
/*     */   public int getDepthOrtho(int tx, int ty) {
/* 139 */     int depth = 16;
/*     */     
/* 141 */     for (int di = 0; di < DIR.ORTHO.size() && depth > 0; di++) {
/* 142 */       DIR d = (DIR)DIR.ORTHO.get(di);
/* 143 */       for (int i = 1; i < 16 && i <= depth; i++) {
/* 144 */         int dx = tx + d.x() * i;
/* 145 */         int dy = ty + d.y() * i;
/* 146 */         if (!SETT.IN_BOUNDS(dx, dy) || (SETT.PATH()).solidity.is(dx, dy))
/*     */           break; 
/* 148 */         if (!canBeBlocked(dx, dy) && 
/* 149 */           i - 1 < depth) {
/* 150 */           depth = i - 1;
/*     */ 
/*     */           
/*     */           break;
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 158 */     return depth;
/*     */   }
/*     */   
/*     */   public int getDepthNortho(int tx, int ty) {
/* 162 */     return tx;
/*     */   }
/*     */   
/*     */   private boolean isBlockingJob(int tx, int ty) {
/* 166 */     Job j = (Job)(SETT.JOBS()).getter.get(tx, ty);
/* 167 */     return (j != null && get(tx, ty) != State.DORMANT && j.becomesSolidNext());
/*     */   }
/*     */   
/*     */   private boolean canBeBlocked(int tx, int ty) {
/* 171 */     Job j = (Job)(SETT.JOBS()).getter.get(tx, ty);
/* 172 */     return (j != null && get(tx, ty) != State.DORMANT && j.becomesSolid());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   void clear(int tx, int ty) {
/* 178 */     set(State.DORMANT, (Job)(SETT.JOBS()).getter.get(tx, ty));
/* 179 */     SETT.JOBS().set(null, tx, ty);
/*     */   }
/*     */ 
/*     */   
/*     */   public void activate(int tile, Job job) {
/* 184 */     if (get(tile) == State.DORMANT)
/* 185 */       set(State.RESERVABLE, job); 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\job\StateManager.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */