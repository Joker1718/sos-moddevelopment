/*     */ package settlement.entity.humanoid.ai.work;
/*     */ 
/*     */ import init.resources.RBIT;
/*     */ import init.resources.RESOURCE;
/*     */ import settlement.entity.humanoid.HPoll;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.entity.humanoid.ai.main.AI;
/*     */ import settlement.entity.humanoid.ai.main.AIManager;
/*     */ import settlement.entity.humanoid.ai.main.AIPLAN;
/*     */ import settlement.entity.humanoid.ai.main.AISUB;
/*     */ import settlement.entity.humanoid.ai.util.AIPlanResourceMany;
/*     */ import settlement.main.SETT;
/*     */ import settlement.room.main.RoomInstance;
/*     */ import settlement.room.main.employment.RoomEmploymentSimple;
/*     */ import settlement.room.main.employment.RoomEquip;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.sprite.text.Str;
/*     */ import util.text.D;
/*     */ 
/*     */ final class PlanFetchEquip extends PlanWork {
/*     */   private final RBIT.RBITImp bit;
/*     */   
/*  23 */   public PlanFetchEquip(String key) { super(key);
/*     */ 
/*     */ 
/*     */     
/*  27 */     this.bit = new RBIT.RBITImp();
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
/*  81 */     this.fetch = new AIPlanResourceMany(this, 64)
/*     */       {
/*     */         public AISUB.AISubActivation next(Humanoid a, AIManager d)
/*     */         {
/*  85 */           AISUB.AISubActivation s = PlanFetchEquip.this.toRoom.set(a, d);
/*  86 */           return s;
/*     */         }
/*     */ 
/*     */         
/*     */         public void cancel(Humanoid a, AIManager d) {
/*  91 */           RoomInstance ins = PlanFetchEquip.work(a);
/*  92 */           if (ins == null)
/*     */             return; 
/*  94 */           RESOURCE res = resource(a, d);
/*  95 */           if (res == null)
/*     */             return; 
/*  97 */           RoomEquip w = PlanFetchEquip.this.eq(res, ins);
/*  98 */           ins.employees().toolReserve(w, -target(a, d));
/*     */         }
/*     */       };
/*     */ 
/*     */ 
/*     */     
/* 104 */     this.toRoom = new AIPLAN.PLANRES.Resumer(this)
/*     */       {
/*     */         protected AISUB.AISubActivation setAction(Humanoid a, AIManager d)
/*     */         {
/* 108 */           RoomInstance ins = PlanFetchEquip.work(a);
/* 109 */           if (ins == null) {
/* 110 */             can(a, d);
/* 111 */             return null;
/*     */           } 
/* 113 */           AISUB.AISubActivation s = (AI.SUBS()).walkTo.room(a, d, ins);
/* 114 */           if (s != null) {
/* 115 */             return s;
/*     */           }
/* 117 */           res(a, d);
/* 118 */           return null;
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 124 */           PlanFetchEquip.this.fetch.cancel(a, d);
/* 125 */           RoomInstance ins = PlanFetchEquip.work(a);
/* 126 */           RoomEquip w = PlanFetchEquip.this.eq(d.resourceCarried(), ins);
/* 127 */           ins.employees().toolDeliver(w, d.resourceA());
/* 128 */           d.resourceCarriedSet(null);
/* 129 */           return null;
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean con(Humanoid a, AIManager d) {
/* 134 */           return (PlanFetchEquip.work(a) != null);
/*     */         }
/*     */         
/*     */         public void can(Humanoid a, AIManager d)
/*     */         {
/* 139 */           PlanFetchEquip.this.fetch.cancel(a, d);
/* 140 */           d.resourceDrop(a);
/*     */         }
/*     */       }; }
/*     */   
/*     */   private static CharSequence ¤¤fetch = "Fetching Work Equipment";
/*     */   
/*     */   protected void name(Humanoid a, AIManager d, Str string) {
/* 147 */     string.add(¤¤fetch);
/*     */   } private final AIPlanResourceMany fetch; private final AIPLAN.PLANRES.Resumer toRoom; static {
/*     */     D.ts(PlanFetchEquip.class);
/*     */   }
/*     */   public double poll(Humanoid a, AIManager d, HPoll.HPollData e) {
/* 152 */     if (e.type == HPoll.WORKING) {
/* 153 */       return 1.0D;
/*     */     }
/* 155 */     return super.poll(a, d, e);
/*     */   }
/*     */   
/*     */   protected AISUB.AISubActivation init(Humanoid a, AIManager d) {
/*     */     RoomInstance ins = work(a);
/*     */     if (ins == null)
/*     */       return null; 
/*     */     RoomEmploymentSimple ee = ins.blueprintI().employment();
/*     */     if (ee == null)
/*     */       return null; 
/*     */     if (ee.tools().size() == 0)
/*     */       return null; 
/*     */     this.bit.clear();
/*     */     for (RoomEquip w : ee.tools()) {
/*     */       if (ins.employees().toolsNeeded(w) > 0)
/*     */         this.bit.or(w.resource); 
/*     */     } 
/*     */     RESOURCE r = (SETT.PATH()).finders.resource.find((RBIT)this.bit, a.tc(), d.path, 2147483647);
/*     */     if (r == null)
/*     */       return null; 
/*     */     for (RoomEquip w : ee.tools()) {
/*     */       int am = ins.employees().toolsNeeded(w);
/*     */       if (am > 0 && r == w.resource) {
/*     */         am = CLAMP.i(am, 0, 15);
/*     */         ins.employees().toolReserve(w, am);
/*     */         return this.fetch.activateFound(a, d, r, am, true, true);
/*     */       } 
/*     */     } 
/*     */     throw new RuntimeException();
/*     */   }
/*     */   
/*     */   private RoomEquip eq(RESOURCE res, RoomInstance ins) {
/*     */     for (RoomEquip w : ins.blueprint().employment().tools()) {
/*     */       if (res == w.resource)
/*     */         return w; 
/*     */     } 
/*     */     throw new RuntimeException();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\work\PlanFetchEquip.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */