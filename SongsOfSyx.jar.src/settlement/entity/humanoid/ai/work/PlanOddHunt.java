/*     */ package settlement.entity.humanoid.ai.work;
/*     */ 
/*     */ import game.audio.AUDIO;
/*     */ import game.audio.SoundRace;
/*     */ import game.faction.FACTIONS;
/*     */ import game.faction.FResources;
/*     */ import init.resources.RESOURCE;
/*     */ import settlement.entity.ENTITY;
/*     */ import settlement.entity.animal.Animal;
/*     */ import settlement.entity.humanoid.HEvent;
/*     */ import settlement.entity.humanoid.HPoll;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.entity.humanoid.ai.main.AI;
/*     */ import settlement.entity.humanoid.ai.main.AIManager;
/*     */ import settlement.entity.humanoid.ai.main.AIPLAN;
/*     */ import settlement.entity.humanoid.ai.main.AISUB;
/*     */ import settlement.main.SETT;
/*     */ import settlement.thing.ThingsCadavers;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.sets.Tuple;
/*     */ import snake2d.util.sprite.text.Str;
/*     */ import util.text.D;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class PlanOddHunt
/*     */ {
/*  34 */   private static CharSequence ¤¤verb = "Hunting";
/*     */   
/*  36 */   private final SoundRace sound = AUDIO.race("SLAUGHTER");
/*     */   
/*     */   static {
/*  39 */     D.ts(PlanOddHunt.class);
/*     */   }
/*     */ 
/*     */   
/*     */   final AIPLAN.PLANRES.ResumerRaw stalk;
/*     */   final AIPLAN.PLANRES.ResumerRaw drag_back;
/*     */   final AIPLAN.PLANRES.ResumerRaw butcher;
/*  46 */   double progress = 0.0D;
/*     */ 
/*     */   
/*     */   public AISUB.AISubActivation init(Humanoid a, AIManager d) {
/*  50 */     Animal prey = (SETT.PATH()).finders.prey.findAndReserve(a.physics.tileC(), d.path, 2147483647);
/*     */     
/*  52 */     if (prey == null) {
/*  53 */       return null;
/*     */     }
/*  55 */     d.planObject = prey.id();
/*  56 */     return this.stalk.set(a, d);
/*     */   }
/*     */ 
/*     */   
/*     */   protected PlanOddHunt(AIPLAN.PLANRES res) {
/*  61 */     this.stalk = new HResumer(this, res)
/*     */       {
/*     */         
/*     */         public double poll(Humanoid a, AIManager d, HPoll.HPollData e)
/*     */         {
/*  66 */           if (e.type == HPoll.SCARE_ANIMAL_NOT)
/*  67 */             return 1.0D; 
/*  68 */           return super.poll(a, d, e);
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean event(Humanoid a, AIManager d, HEvent.HEventData e) {
/*  73 */           if (e.event == HEvent.COLLISION_SOFT)
/*     */           {
/*  75 */             if (e.other instanceof Animal) {
/*  76 */               Animal prey = PlanOddHunt.this.getPrey(a, d);
/*  77 */               Animal an = (Animal)e.other;
/*  78 */               if (prey != an && 
/*  79 */                 an.huntReservable()) {
/*  80 */                 if (prey != null)
/*  81 */                   prey.huntReserveCancel(); 
/*  82 */                 prey = an;
/*  83 */                 prey.huntReserve();
/*  84 */                 d.planObject = prey.id();
/*     */               } 
/*     */ 
/*     */               
/*  88 */               if (prey == an) {
/*  89 */                 a.speed.magnitudeInit(0.0D);
/*  90 */                 AISUB.AISubActivation s = PlanOddHunt.this.drag_back.trySet(a, d);
/*  91 */                 if (s != null) {
/*  92 */                   d.overwrite(a, s);
/*  93 */                   return false;
/*     */                 } 
/*     */               } 
/*     */             } 
/*     */           }
/*     */ 
/*     */ 
/*     */           
/* 101 */           return super.event(a, d, e);
/*     */         }
/*     */ 
/*     */         
/*     */         public AISUB.AISubActivation setAction(Humanoid a, AIManager d) {
/* 106 */           AISUB.AISubActivation ac = (AI.SUBS()).walkTo.path(a, d);
/* 107 */           if (ac != null)
/* 108 */             return ac; 
/* 109 */           can(a, d);
/* 110 */           return null;
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 116 */           Animal prey = PlanOddHunt.this.getPrey(a, d);
/* 117 */           int dx = prey.physics.tileC().x() - a.physics.tileC().x();
/* 118 */           int dy = prey.physics.tileC().y() - a.physics.tileC().y();
/*     */           
/* 120 */           if (Math.abs(dx) + Math.abs(dy) == 1) {
/* 121 */             return PlanOddHunt.this.drag_back.set(a, d);
/*     */           }
/*     */ 
/*     */           
/* 125 */           AISUB.AISubActivation ac = (AI.SUBS()).walkTo.coo(a, d, prey.physics.tileC());
/* 126 */           if (ac != null)
/* 127 */             return ac; 
/* 128 */           can(a, d);
/* 129 */           return null;
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public boolean con(Humanoid a, AIManager d) {
/* 135 */           return (PlanOddHunt.this.getPrey(a, d) != null);
/*     */         }
/*     */ 
/*     */         
/*     */         public void can(Humanoid a, AIManager d) {
/* 140 */           Animal prey = PlanOddHunt.this.getPrey(a, d);
/* 141 */           if (prey != null) {
/* 142 */             prey.huntReserveCancel();
/*     */           }
/*     */         }
/*     */       };
/*     */     
/* 147 */     this.drag_back = new HResumer(this, res)
/*     */       {
/*     */ 
/*     */         
/*     */         public boolean con(Humanoid a, AIManager d)
/*     */         {
/* 153 */           return (PlanOddHunt.this.getCadaver(a, d) != null);
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public void can(Humanoid a, AIManager d) {}
/*     */ 
/*     */ 
/*     */         
/*     */         public AISUB.AISubActivation setAction(Humanoid a, AIManager d) {
/* 163 */           ThingsCadavers.Cadaver c = PlanOddHunt.this.getPrey(a, d).slaugher();
/*     */           
/* 165 */           if (c != null) {
/* 166 */             d.planObject = c.index();
/* 167 */             Tuple<COORDINATE, RESOURCE> coo = (SETT.PATH()).finders.storage.reserve(a.tc().x(), a.tc().y(), (c.spec()).rBit, 2147483647);
/* 168 */             if (coo == null)
/* 169 */               return PlanOddHunt.this.butcher.set(a, d); 
/* 170 */             d.planTile.set((COORDINATE)coo.a());
/* 171 */             (SETT.PATH()).finders.storage.cancelReservation((COORDINATE)d.planTile, ((RESOURCE)coo.b()).bIndex());
/* 172 */             AISUB.AISubActivation ac = (AI.SUBS()).walkTo.drag(a, d, (SETT.THINGS()).cadavers.draggable, c.index(), (COORDINATE)d.planTile);
/* 173 */             if (ac != null)
/* 174 */               return ac; 
/* 175 */             return PlanOddHunt.this.butcher.set(a, d);
/*     */           } 
/* 177 */           can(a, d);
/* 178 */           return null;
/*     */         }
/*     */ 
/*     */         
/*     */         public AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 183 */           return PlanOddHunt.this.butcher.set(a, d);
/*     */         }
/*     */       };
/*     */     
/* 187 */     this.butcher = new HResumer(this, res)
/*     */       {
/*     */         public AISUB.AISubActivation res(Humanoid a, AIManager d)
/*     */         {
/* 191 */           ThingsCadavers.Cadaver prey = PlanOddHunt.this.getCadaver(a, d);
/*     */           
/* 193 */           if (prey == null) {
/* 194 */             can(a, d);
/* 195 */             return null;
/*     */           } 
/* 197 */           a.speed.setDirCurrent(DIR.get(a.tc(), prey.ctx(), prey.cty()));
/* 198 */           if (prey.resHas()) {
/* 199 */             RESOURCE r = prey.resRemove();
/* 200 */             (SETT.THINGS()).resources.create(prey.ctx(), prey.cty(), r, 1);
/* 201 */             FACTIONS.player().res().inc(r, FResources.RTYPE.PRODUCED, 1);
/*     */           } 
/*     */           
/* 204 */           if (prey.resHas()) {
/* 205 */             PlanOddHunt.this.sound.rnd(a);
/* 206 */             return (AI.SUBS()).WORK_HANDS.activate(a, d, 5.0D);
/*     */           } 
/* 208 */           return null;
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public boolean con(Humanoid a, AIManager d) {
/* 215 */           return true;
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public void can(Humanoid a, AIManager d) {}
/*     */ 
/*     */ 
/*     */         
/*     */         public AISUB.AISubActivation setAction(Humanoid a, AIManager d) {
/* 225 */           return (AI.SUBS()).WORK_HANDS.activate(a, d, 12.0D);
/*     */         }
/*     */       };
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private Animal getPrey(Humanoid a, AIManager d) {
/* 238 */     if (d.planObject == -1)
/* 239 */       return null; 
/* 240 */     ENTITY e = SETT.ENTITIES().getByID(d.planObject);
/*     */     
/* 242 */     if (e == null || !(e instanceof Animal) || !((Animal)e).huntReserved()) {
/* 243 */       d.planObject = -1;
/* 244 */       return null;
/*     */     } 
/* 246 */     return (Animal)e;
/*     */   }
/*     */   
/*     */   private ThingsCadavers.Cadaver getCadaver(Humanoid a, AIManager d) {
/* 250 */     if (d.planObject == -1)
/* 251 */       return null; 
/* 252 */     ThingsCadavers.Cadaver e = (SETT.THINGS()).cadavers.getByIndex(d.planObject);
/*     */     
/* 254 */     if (e == null || e.isRemoved() || !e.resHas()) {
/* 255 */       d.planObject = -1;
/* 256 */       return null;
/*     */     } 
/* 258 */     return e;
/*     */   }
/*     */ 
/*     */   
/*     */   private abstract class HResumer
/*     */     extends AIPLAN.PLANRES.ResumerRaw
/*     */   {
/*     */     public HResumer(AIPLAN.PLANRES daddy) {
/* 266 */       super(daddy);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public double poll(Humanoid a, AIManager d, HPoll.HPollData e) {
/* 272 */       if (e.type == HPoll.SCARE_ANIMAL_NOT)
/* 273 */         return 1.0D; 
/* 274 */       return super.poll(a, d, e);
/*     */     }
/*     */ 
/*     */     
/*     */     protected void name(Humanoid a, AIManager d, Str string) {
/* 279 */       string.add(PlanOddHunt.¤¤verb);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\work\PlanOddHunt.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */