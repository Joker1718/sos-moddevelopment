/*     */ package settlement.entity.humanoid.ai.service;
/*     */ 
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.entity.humanoid.ai.main.AI;
/*     */ import settlement.entity.humanoid.ai.main.AIManager;
/*     */ import settlement.entity.humanoid.ai.main.AIPLAN;
/*     */ import settlement.entity.humanoid.ai.main.AISUB;
/*     */ import settlement.main.SETT;
/*     */ import settlement.misc.util.FINDABLE;
/*     */ import settlement.path.finders.SFinderFindable;
/*     */ import settlement.room.main.Room;
/*     */ import settlement.room.main.furnisher.FurnisherItem;
/*     */ import settlement.room.spirit.temple.ROOM_TEMPLE;
/*     */ import settlement.stats.STATS;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.Coo;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.rnd.RND;
/*     */ import snake2d.util.sprite.text.Str;
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
/*     */ class null
/*     */   extends AIPLAN.PLANRES
/*     */ {
/*     */   private final AIPLAN.PLANRES.Resumer walk;
/*     */   private final AIPLAN.PLANRES.Resumer pray;
/*     */   private final AIPLAN.PLANRES.Resumer next;
/*     */   
/*     */   null(String $anonymous0) {
/*  64 */     super($anonymous0);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  71 */     this.walk = new AIPLAN.PLANRES.Resumer(this, null)
/*     */       {
/*     */         protected AISUB.AISubActivation setAction(Humanoid a, AIManager d)
/*     */         {
/*  75 */           d.planByte4 = 0;
/*  76 */           for (ROOM_TEMPLE t : S_PlanTemple.null.access$0(S_PlanTemple.null.this).services(a, d)) {
/*  77 */             AISUB.AISubActivation s = (AI.SUBS()).walkTo.serviceInclude(a, d, (SFinderFindable)(t.service()).finder, (t.service()).radius);
/*  78 */             if (s != null) {
/*  79 */               d.planByte4 = (byte)t.typeIndex();
/*  80 */               (S_PlanTemple.null.access$0(S_PlanTemple.null.this)).aa.set(a.id(), true);
/*  81 */               return s;
/*     */             } 
/*     */           } 
/*     */           
/*  85 */           return null;
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/*  91 */           (STATS.RELIGION()).TEMPLE.setAccess(a);
/*  92 */           return S_PlanTemple.null.this.pray.set(a, d);
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean con(Humanoid a, AIManager d) {
/*  97 */           return true;
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public void can(Humanoid a, AIManager d) {}
/*     */ 
/*     */ 
/*     */         
/*     */         protected void name(Humanoid a, AIManager d, Str string) {
/* 107 */           string.add((S_PlanTemple.null.this.temp(d).service()).verb);
/*     */         }
/*     */       };
/*     */     
/* 111 */     this.pray = new AIPLAN.PLANRES.Resumer(this, null)
/*     */       {
/*     */         protected AISUB.AISubActivation setAction(Humanoid a, AIManager d)
/*     */         {
/* 115 */           d.planTile.set(d.path.destX(), d.path.destY());
/* 116 */           d.planByte1 = (byte)(5 + RND.rInt(10));
/*     */           
/* 118 */           FurnisherItem it = (FurnisherItem)(SETT.ROOMS()).fData.item.get(a.tc());
/* 119 */           if (it != null) {
/* 120 */             COORDINATE c = (SETT.ROOMS()).fData.itemX1Y1(a.tc(), Coo.TMP);
/* 121 */             if (c != null) {
/*     */               
/* 123 */               int dx = c.x() + it.width() / 2;
/* 124 */               int dy = c.y() + it.height() / 2;
/*     */               
/* 126 */               DIR dir = DIR.get(a.tc().x(), a.tc().y(), dx, dy);
/* 127 */               a.speed.setDirCurrent(dir);
/*     */             } 
/*     */           } 
/*     */           
/* 131 */           return res(a, d);
/*     */         }
/*     */ 
/*     */         
/*     */         protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 136 */           d.planByte1 = (byte)(d.planByte1 - 1);
/* 137 */           if (d.planByte1 <= 0 || S_PlanTemple.null.this.temp(d).service().available() < S_PlanTemple.null.this.temp(d).service().total() / 4) {
/* 138 */             FINDABLE s = (S_PlanTemple.null.this.temp(d).service()).finder.getReserved(d.planTile.x(), d.planTile.y());
/* 139 */             if (s != null)
/* 140 */               s.findableReserveCancel(); 
/* 141 */             return S_PlanTemple.null.this.next.set(a, d);
/*     */           } 
/* 143 */           if (RND.rBoolean()) {
/* 144 */             return (AI.SUBS()).single.activate(a, d, (AI.STATES()).anima.lay, (4 + RND.rInt(4)));
/*     */           }
/* 146 */           if (RND.rBoolean())
/* 147 */             return (AI.SUBS()).single.activate(a, d, (AI.STATES()).anima.carry, (4 + RND.rInt(4))); 
/* 148 */           return (AI.SUBS()).single.activate(a, d, (AI.STATES()).anima.stand, (4 + RND.rInt(4)));
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public boolean con(Humanoid a, AIManager d) {
/* 154 */           return true;
/*     */         }
/*     */ 
/*     */         
/*     */         public void can(Humanoid a, AIManager d) {
/* 159 */           FINDABLE s = (S_PlanTemple.null.this.temp(d).service()).finder.getReserved(d.planTile.x(), d.planTile.y());
/* 160 */           if (s != null) {
/* 161 */             s.findableReserveCancel();
/*     */           }
/*     */         }
/*     */         
/*     */         protected void name(Humanoid a, AIManager d, Str string) {
/* 166 */           string.add((S_PlanTemple.null.this.temp(d).service()).verb);
/*     */         }
/*     */       };
/*     */     
/* 170 */     this.next = new AIPLAN.PLANRES.Resumer(this, null)
/*     */       {
/*     */         protected AISUB.AISubActivation setAction(Humanoid a, AIManager d)
/*     */         {
/* 174 */           Room r = (Room)(SETT.ROOMS()).map.get(a.tc());
/* 175 */           d.planByte1 = (byte)(5 + RND.rInt(10));
/* 176 */           if (r != null)
/* 177 */             return (AI.SUBS()).walkTo.room(a, d, a.tc().x(), a.tc().y()); 
/* 178 */           return null;
/*     */         }
/*     */ 
/*     */         
/*     */         protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 183 */           d.planByte1 = (byte)(d.planByte1 - 1);
/* 184 */           if (d.planByte1 <= 0) {
/* 185 */             return null;
/*     */           }
/* 187 */           if (RND.rBoolean()) {
/* 188 */             return (AI.SUBS()).single.activate(a, d, (AI.STATES()).anima.lay, (4 + RND.rInt(4)));
/*     */           }
/* 190 */           if (RND.rBoolean())
/* 191 */             return (AI.SUBS()).single.activate(a, d, (AI.STATES()).anima.carry, (4 + RND.rInt(4))); 
/* 192 */           return (AI.SUBS()).single.activate(a, d, (AI.STATES()).anima.stand, (4 + RND.rInt(4)));
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public boolean con(Humanoid a, AIManager d) {
/* 198 */           return true;
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public void can(Humanoid a, AIManager d) {}
/*     */ 
/*     */         
/*     */         protected void name(Humanoid a, AIManager d, Str string)
/*     */         {
/* 208 */           string.add((S_PlanTemple.null.this.temp(d).service()).verb);
/*     */         }
/*     */       };
/*     */   }
/*     */   private ROOM_TEMPLE temp(AIManager d) {
/* 213 */     return (ROOM_TEMPLE)(SETT.ROOMS()).TEMPLES.ALL.get(d.planByte4);
/*     */   }
/*     */   
/*     */   protected AISUB.AISubActivation init(Humanoid a, AIManager d) {
/*     */     return this.walk.set(a, d);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\service\S_PlanTemple$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */