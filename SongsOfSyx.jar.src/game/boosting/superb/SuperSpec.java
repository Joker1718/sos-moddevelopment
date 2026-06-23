/*     */ package game.boosting.superb;
/*     */ 
/*     */ import game.boosting.BSourceInfo;
/*     */ import game.boosting.Booster;
/*     */ import game.boosting.BoosterAbs;
/*     */ import game.time.TIME;
/*     */ import init.type.HCLASS_RACE;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import util.data.DOUBLE_O;
/*     */ 
/*     */ public abstract class SuperSpec<T extends SuperBoostableObj>
/*     */   extends BoosterAbs<T> {
/*     */   private final double from;
/*     */   private final double to;
/*     */   public final CharSequence desc;
/*     */   public boolean hidden = false;
/*     */   
/*     */   SuperSpec(SuperBoostable<T> self, BSourceInfo info, CharSequence desc, double to, boolean isMul) {
/*  19 */     this(self, info, desc, (isMul ? true : false), to, isMul);
/*     */   }
/*     */   
/*     */   protected SuperSpec(SuperBoostable<T> self, BSourceInfo info, CharSequence desc, double from, double to, boolean isMul) {
/*  23 */     super(info, isMul);
/*  24 */     this.to = to;
/*  25 */     this.from = from;
/*  26 */     this.desc = desc;
/*  27 */     if (isMul) {
/*  28 */       from = 1.0D;
/*     */     } else {
/*  30 */       from = 0.0D;
/*     */     } 
/*  32 */     self.all.add(this);
/*     */   }
/*     */ 
/*     */   
/*     */   public double from() {
/*  37 */     return this.from;
/*     */   }
/*     */ 
/*     */   
/*     */   public double to() {
/*  42 */     return this.to;
/*     */   }
/*     */ 
/*     */   
/*     */   public double getValue(double input) {
/*  47 */     input = CLAMP.d(input, 0.0D, 1.0D);
/*  48 */     return from() + input * (to() - from());
/*     */   }
/*     */   public abstract double secondsRemaining(T paramT);
/*     */   
/*     */   public abstract double increase(T paramT);
/*     */   
/*     */   public double getModifier(T bo) {
/*  55 */     return 1.0D;
/*     */   }
/*     */   public static abstract class SuperSpecImp<T extends SuperBoostableObj> extends SuperSpec<T> {
/*     */     public final int index;
/*     */     public final String key;
/*     */     public final DOUBLE_O.DOUBLE_OE<SuperBoostableObj> value;
/*     */     public final DOUBLE_O.DOUBLE_OE<SuperBoostableObj> time;
/*     */     public final DOUBLE_O.DOUBLE_OE<T> state;
/*     */     
/*  64 */     public SuperSpecImp(SuperBoostable<T> self, String key, BSourceInfo info, CharSequence desc, double to, boolean isMul) { super(self, info, desc, to, isMul);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*  74 */       this.value = new DOUBLE_O.DOUBLE_OE<SuperBoostableObj>()
/*     */         {
/*     */           public double getD(SuperBoostableObj t)
/*     */           {
/*  78 */             return t.boostingData().values()[SuperSpec.SuperSpecImp.this.index];
/*     */           }
/*     */ 
/*     */           
/*     */           public DOUBLE_O.DOUBLE_OE<SuperBoostableObj> setD(SuperBoostableObj t, double d) {
/*  83 */             t.boostingData().values()[SuperSpec.SuperSpecImp.this.index] = CLAMP.d(d, 0.0D, 1.0D);
/*  84 */             return this;
/*     */           }
/*     */         };
/*     */       
/*  88 */       this.time = new DOUBLE_O.DOUBLE_OE<SuperBoostableObj>()
/*     */         {
/*     */           public double getD(SuperBoostableObj t)
/*     */           {
/*  92 */             return t.boostingData().times()[SuperSpec.SuperSpecImp.this.index];
/*     */           }
/*     */ 
/*     */           
/*     */           public DOUBLE_O.DOUBLE_OE<SuperBoostableObj> setD(SuperBoostableObj t, double d) {
/*  97 */             t.boostingData().times()[SuperSpec.SuperSpecImp.this.index] = d;
/*  98 */             return this;
/*     */           }
/*     */         };
/*     */       
/* 102 */       this.state = new DOUBLE_O.DOUBLE_OE<T>()
/*     */         {
/*     */           public double getD(T t)
/*     */           {
/* 106 */             return t.boostingData().states()[SuperSpec.SuperSpecImp.this.index];
/*     */           }
/*     */ 
/*     */           
/*     */           public DOUBLE_O.DOUBLE_OE<T> setD(T t, double d) {
/* 111 */             t.boostingData().states()[SuperSpec.SuperSpecImp.this.index] = d;
/* 112 */             return this; } };
/*     */       while (self.map.containsKey(key))
/*     */         key = key + "0"; 
/*     */       this.key = key;
/*     */       self.map.put(this.key, this);
/* 117 */       this.index = self.ups.add(this); } public void toggle(T bo) { activate(bo, !activated(bo)); }
/*     */ 
/*     */     
/*     */     public abstract void update(T param1T, double param1Double);
/*     */     
/*     */     public abstract void activate(T param1T, boolean param1Boolean);
/*     */     
/*     */     public abstract boolean activated(T param1T);
/*     */   }
/*     */   
/*     */   public static class Permanent<T extends SuperBoostableObj> extends SuperSpecImp<T> {
/*     */     public Permanent(SuperBoostable<T> self, String key, BSourceInfo info, CharSequence desc, double to, boolean isMul) {
/* 129 */       super(self, key, info, desc, to, isMul);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public void update(T bo, double time) {}
/*     */ 
/*     */ 
/*     */     
/*     */     public void activate(T bo, boolean active) {
/* 139 */       this.value.setD(bo, (active ? true : false));
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean activated(T bo) {
/* 144 */       return (this.value.getD(bo) > 0.0D);
/*     */     }
/*     */ 
/*     */     
/*     */     public double secondsRemaining(T bo) {
/* 149 */       return 0.0D;
/*     */     }
/*     */ 
/*     */     
/*     */     public double increase(T bo) {
/* 154 */       return 0.0D;
/*     */     }
/*     */ 
/*     */     
/*     */     protected double pget(T bo) {
/* 159 */       return this.value.getD(bo);
/*     */     }
/*     */   }
/*     */   
/*     */   static class Wrap<T extends SuperBoostableObj>
/*     */     extends SuperSpec<T>
/*     */   {
/*     */     private final Booster boo;
/*     */     
/*     */     public Wrap(Booster b, SuperBoostable<T> self, String key, BSourceInfo info, CharSequence desc) {
/* 169 */       super(self, info, desc, b.to(), b.isMul);
/* 170 */       this.boo = b;
/*     */     }
/*     */ 
/*     */     
/*     */     public double get(T o) {
/* 175 */       return this.boo.get(HCLASS_RACE.clP());
/*     */     }
/*     */ 
/*     */     
/*     */     public double pget(T bo) {
/* 180 */       return 0.0D;
/*     */     }
/*     */ 
/*     */     
/*     */     public double secondsRemaining(T bo) {
/* 185 */       return 0.0D;
/*     */     }
/*     */ 
/*     */     
/*     */     public double increase(T bo) {
/* 190 */       return 0.0D;
/*     */     }
/*     */   }
/*     */   
/*     */   public static class TimeLimit<T extends SuperBoostableObj>
/*     */     extends SuperSpecImp<T>
/*     */   {
/*     */     private final double seconds;
/*     */     
/*     */     public TimeLimit(double days, SuperBoostable<T> self, String key, BSourceInfo info, CharSequence desc, double to, boolean isMul) {
/* 200 */       super(self, key, info, desc, to, isMul);
/* 201 */       this.seconds = days * TIME.secondsPerDay();
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public void update(T bo, double time) {
/* 207 */       if (this.time.getD(bo) > 0.0D) {
/* 208 */         this.time.incD(bo, -time);
/*     */       }
/*     */     }
/*     */ 
/*     */     
/*     */     public double pget(T bo) {
/* 214 */       if (this.time.getD(bo) > 0.0D)
/* 215 */         return 1.0D; 
/* 216 */       return 0.0D;
/*     */     }
/*     */ 
/*     */     
/*     */     public void activate(T bo, boolean active) {
/* 221 */       this.time.setD(bo, active ? this.seconds : 0.0D);
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean activated(T bo) {
/* 226 */       return (this.time.getD(bo) > 0.0D);
/*     */     }
/*     */ 
/*     */     
/*     */     public double secondsRemaining(T bo) {
/* 231 */       return this.time.getD(bo);
/*     */     }
/*     */ 
/*     */     
/*     */     public double increase(T bo) {
/* 236 */       return 0.0D;
/*     */     }
/*     */   }
/*     */   
/*     */   public static class Downer<T extends SuperBoostableObj>
/*     */     extends SuperSpecImp<T>
/*     */   {
/*     */     private final double decreaseTime;
/*     */     private final double durationDays;
/*     */     
/*     */     public Downer(double daysToDecrease, SuperBoostable<T> self, String key, BSourceInfo info, CharSequence desc, double to, boolean isMul, double durationDays) {
/* 247 */       super(self, key, info, desc, to, isMul);
/* 248 */       if (daysToDecrease == 0.0D)
/* 249 */         throw new RuntimeException(); 
/* 250 */       this.decreaseTime = daysToDecrease * TIME.secondsPerDayI();
/* 251 */       this.durationDays = durationDays;
/*     */     }
/*     */ 
/*     */     
/*     */     public void update(T bo, double time) {
/* 256 */       if (this.time.getD(bo) > 0.0D) {
/* 257 */         this.time.incD(bo, -time);
/*     */         return;
/*     */       } 
/* 260 */       this.value.incD(bo, -time * this.decreaseTime);
/*     */     }
/*     */ 
/*     */     
/*     */     public void activate(T bo, boolean active) {
/* 265 */       this.value.setD(bo, active ? 1.0D : 0.0D);
/* 266 */       this.time.setD(bo, this.durationDays * TIME.secondsPerDay());
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean activated(T bo) {
/* 271 */       return (this.value.getD(bo) > 0.0D);
/*     */     }
/*     */ 
/*     */     
/*     */     public double secondsRemaining(T bo) {
/* 276 */       return this.time.getD(bo);
/*     */     }
/*     */ 
/*     */     
/*     */     public double increase(T bo) {
/* 281 */       return -this.decreaseTime * TIME.secondsPerDay();
/*     */     }
/*     */ 
/*     */     
/*     */     protected double pget(T o) {
/* 286 */       return this.value.getD(o);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public static class Uper<T extends SuperBoostableObj>
/*     */     extends SuperSpecImp<T>
/*     */   {
/*     */     private final double decreaseTime;
/*     */     private final double maxTime;
/*     */     
/*     */     public Uper(double daysToIncrease, SuperBoostable<T> self, String key, BSourceInfo info, CharSequence desc, double to, boolean isMul) {
/* 298 */       this(daysToIncrease, -1.0D, self, key, info, desc, to, isMul);
/*     */     }
/*     */     
/*     */     public Uper(double daysToDecrease, double maxDays, SuperBoostable<T> self, String key, BSourceInfo info, CharSequence desc, double to, boolean isMul) {
/* 302 */       super(self, key, info, desc, to, isMul);
/* 303 */       if (daysToDecrease == 0.0D)
/* 304 */         throw new RuntimeException(); 
/* 305 */       this.decreaseTime = daysToDecrease * TIME.secondsPerDayI();
/* 306 */       this.maxTime = maxDays * TIME.secondsPerDay();
/*     */     }
/*     */ 
/*     */     
/*     */     public void update(T bo, double time) {
/* 311 */       if (this.state.getD(bo) == 1.0D) {
/* 312 */         if (this.maxTime >= 0.0D) {
/* 313 */           double t = this.time.incD(bo, -time).getD(bo);
/* 314 */           if (t <= 0.0D) {
/* 315 */             activate(bo, false);
/*     */             
/*     */             return;
/*     */           } 
/*     */         } 
/*     */         
/* 321 */         this.value.incD(bo, time * this.decreaseTime);
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public double pget(T bo) {
/* 328 */       if (this.state.getD(bo) == 0.0D)
/* 329 */         return 0.0D; 
/* 330 */       if (this.maxTime > 0.0D && this.time.getD(bo) <= 0.0D)
/* 331 */         return 0.0D; 
/* 332 */       return this.value.getD(bo);
/*     */     }
/*     */ 
/*     */     
/*     */     public void activate(T bo, boolean active) {
/* 337 */       this.time.setD(bo, this.maxTime);
/* 338 */       this.value.setD(bo, 0.0D);
/* 339 */       this.state.setD(bo, (active ? true : false));
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean activated(T bo) {
/* 345 */       return (this.state.getD(bo) == 1.0D);
/*     */     }
/*     */ 
/*     */     
/*     */     public double secondsRemaining(T bo) {
/* 350 */       if (this.maxTime >= 0.0D)
/* 351 */         return this.time.getD(bo); 
/* 352 */       return 0.0D;
/*     */     }
/*     */ 
/*     */     
/*     */     public double increase(T bo) {
/* 357 */       return this.decreaseTime * TIME.secondsPerDay();
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\boosting\superb\SuperSpec.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */