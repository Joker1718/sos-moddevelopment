/*     */ package settlement.entity.humanoid.ai.consume;
/*     */ 
/*     */ import init.resources.Meal;
/*     */ import init.type.NEEDS;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.entity.humanoid.ai.main.AI;
/*     */ import settlement.entity.humanoid.ai.main.AIManager;
/*     */ import settlement.entity.humanoid.ai.main.AIPLAN;
/*     */ import settlement.entity.humanoid.ai.main.AISUB;
/*     */ import settlement.main.SETT;
/*     */ import settlement.room.service.food.canteen.ROOM_CANTEEN;
/*     */ import settlement.stats.STATS;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.rnd.RND;
/*     */ 
/*     */ final class F_SPlanCanteen extends SPlanAbs<ROOM_CANTEEN> {
/*     */   private final AISUB eat;
/*     */   final AIPLAN.PLANRES.Resumer first;
/*     */   
/*     */   public F_SPlanCanteen(AISUB eat) {
/*  22 */     super("Canteen", (SETT.ROOMS()).CANTEENS, false);
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
/*  33 */     this.first = new AIPLAN.PLANRES.Resumer(this, "1")
/*     */       {
/*     */         
/*     */         protected AISUB.AISubActivation setAction(Humanoid a, AIManager d)
/*     */         {
/*  38 */           int da = F_SPlanCanteen.this.blue(d).grab((a.race().pref()).food, (STATS.FOOD()).FOOD.decree().get(a), d.planTile.x(), d.planTile.y());
/*     */           
/*  40 */           STATS.FOOD().eat(a, Meal.amount(da), Meal.pref(da));
/*  41 */           COORDINATE c = F_SPlanCanteen.this.blue(d).getChair(d.planTile.x(), d.planTile.y());
/*     */           
/*  43 */           if (c != null) {
/*  44 */             AISUB.AISubActivation s = (AI.SUBS()).walkTo.cooFull(a, d, c);
/*  45 */             if (s != null) {
/*  46 */               d.planTile.set(c);
/*  47 */               d.planObject = da;
/*  48 */               F_SPlanCanteen.this.walkTable.set(a, d);
/*  49 */               return s;
/*     */             } 
/*     */           } 
/*  52 */           return F_SPlanCanteen.this.eat.activate(a, d);
/*     */         }
/*     */ 
/*     */         
/*     */         protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/*  57 */           return null;
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean con(Humanoid a, AIManager d) {
/*  62 */           return true;
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public void can(Humanoid a, AIManager d) {}
/*     */       };
/*  71 */     this.walkTable = new AIPLAN.PLANRES.Resumer(this, "2")
/*     */       {
/*     */         protected AISUB.AISubActivation setAction(Humanoid a, AIManager d)
/*     */         {
/*  75 */           return null;
/*     */         }
/*     */ 
/*     */         
/*     */         protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/*  80 */           return F_SPlanCanteen.this.walkLast.set(a, d);
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean con(Humanoid a, AIManager d) {
/*  85 */           return F_SPlanCanteen.this.blue(d).is((COORDINATE)d.planTile);
/*     */         }
/*     */ 
/*     */         
/*     */         public void can(Humanoid a, AIManager d) {
/*  90 */           F_SPlanCanteen.this.blue(d).returnChair(d.planTile.x(), d.planTile.y());
/*     */         }
/*     */       };
/*     */     
/*  94 */     this.walkLast = new AIPLAN.PLANRES.Resumer(this, "3")
/*     */       {
/*     */         protected AISUB.AISubActivation setAction(Humanoid a, AIManager d)
/*     */         {
/*  98 */           DIR dir = F_SPlanCanteen.this.blue(d).setChair(d.planTile.x(), d.planTile.y(), d.planObject);
/*  99 */           if (dir != null) {
/* 100 */             return (AI.SUBS()).single.activate(a, d, (AI.STATES()).WALK2.moveToEdge(a, d, dir));
/*     */           }
/* 102 */           return null;
/*     */         }
/*     */ 
/*     */         
/*     */         protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 107 */           a.speed.magnitudeInit(0.0D);
/* 108 */           return F_SPlanCanteen.this.eatTable.set(a, d);
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean con(Humanoid a, AIManager d) {
/* 113 */           return F_SPlanCanteen.this.walkTable.con(a, d);
/*     */         }
/*     */ 
/*     */         
/*     */         public void can(Humanoid a, AIManager d) {
/* 118 */           F_SPlanCanteen.this.walkTable.can(a, d);
/*     */         }
/*     */       };
/*     */     
/* 122 */     this.eatTable = new AIPLAN.PLANRES.Resumer(this, "4")
/*     */       {
/*     */         
/*     */         public AISUB.AISubActivation setAction(Humanoid a, AIManager d)
/*     */         {
/* 127 */           d.planByte1 = (byte)(4 + RND.rInt(10));
/* 128 */           return F_SPlanCanteen.this.eat.activate(a, d);
/*     */         }
/*     */ 
/*     */         
/*     */         public AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 133 */           d.planByte1 = (byte)(d.planByte1 - 1);
/* 134 */           if (d.planByte1 < 0) {
/* 135 */             can(a, d);
/* 136 */             if ((NEEDS.TYPES()).HUNGER.stat().getPrio(a) > 0)
/* 137 */               return F_SPlanCanteen.this.init(a, d); 
/* 138 */             return null;
/*     */           } 
/* 140 */           return F_SPlanCanteen.this.eat.activate(a, d);
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public boolean con(Humanoid a, AIManager d) {
/* 146 */           return F_SPlanCanteen.this.walkTable.con(a, d);
/*     */         }
/*     */ 
/*     */         
/*     */         public void can(Humanoid a, AIManager d) {
/* 151 */           F_SPlanCanteen.this.walkTable.can(a, d);
/*     */         }
/*     */       };
/*     */     this.eat = eat;
/*     */   }
/*     */   
/*     */   final AIPLAN.PLANRES.Resumer walkTable;
/*     */   final AIPLAN.PLANRES.Resumer walkLast;
/*     */   final AIPLAN.PLANRES.Resumer eatTable;
/*     */   
/*     */   protected AISUB.AISubActivation arrive(Humanoid a, AIManager d) {
/*     */     return this.first.set(a, d);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\consume\F_SPlanCanteen.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */