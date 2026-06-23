/*     */ package settlement.entity.humanoid.ai.types.student;
/*     */ import game.boosting.BOOSTABLE_O;
/*     */ import init.sprite.UI.UI;
/*     */ import init.type.HTYPE;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.entity.humanoid.ai.main.AIManager;
/*     */ import settlement.entity.humanoid.ai.main.AIModule;
/*     */ import settlement.entity.humanoid.ai.main.AIPLAN;
/*     */ import settlement.main.SETT;
/*     */ import settlement.room.knowledge.university.ROOM_UNIVERSITY;
/*     */ import settlement.room.main.RoomInstance;
/*     */ import settlement.stats.STATS;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.text.D;
/*     */ 
/*     */ public final class AIModule_Student extends AIModule {
/*  17 */   private final Plan plan = new Plan(this);
/*     */   
/*  19 */   private static CharSequence ¤¤name = "Study";
/*  20 */   private static CharSequence ¤¤desc = "Gain some education or indoctrination in a learning facility";
/*     */   static {
/*  22 */     D.ts(AIModule_Student.class);
/*     */   }
/*     */   
/*     */   public AIModule_Student() {
/*  26 */     super((SPRITE)(UI.icons()).s.admin, ¤¤name, ¤¤desc);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean tryInit(Humanoid h, AIManager d) {
/*  32 */     return (getFirstUni(h, d) != null);
/*     */   }
/*     */   
/*     */   public static boolean shouldContinue(Humanoid h, AIManager d) {
/*  36 */     ROOM_UNIVERSITY uu = uni(h);
/*  37 */     if (uu == null) {
/*  38 */       return false;
/*     */     }
/*  40 */     if (!checkUni(h, d, uu))
/*  41 */       return false; 
/*  42 */     if (((RoomInstance)(STATS.WORK()).EMPLOYED.get(h)).employees().isOverstaffed())
/*  43 */       return false; 
/*  44 */     if (uu.bonus().get((BOOSTABLE_O)h.indu()) <= 0.0D)
/*  45 */       return false; 
/*  46 */     return true;
/*     */   }
/*     */   
/*     */   static ROOM_UNIVERSITY uni(Humanoid h) {
/*  50 */     RoomInstance ii = (RoomInstance)(STATS.WORK()).EMPLOYED.get(h);
/*  51 */     if (ii != null && ii.blueprintI() instanceof ROOM_UNIVERSITY)
/*  52 */       return (ROOM_UNIVERSITY)ii.blueprintI(); 
/*  53 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   private ROOM_UNIVERSITY getFirstUni(Humanoid h, AIManager d) {
/*  58 */     ROOM_UNIVERSITY best = null;
/*  59 */     double bv = 0.0D;
/*  60 */     for (ROOM_UNIVERSITY u : (SETT.ROOMS()).UNIVERSITIES) {
/*  61 */       if (u.emp.employable() > 0 && checkUni(h, d, u)) {
/*  62 */         double r = u.learningSpeed * u.bonus().get((BOOSTABLE_O)h.indu());
/*  63 */         if (r > bv) {
/*  64 */           bv = r;
/*  65 */           best = u;
/*     */         } 
/*     */       } 
/*     */     } 
/*  69 */     return best;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static boolean checkUni(Humanoid h, AIManager d, ROOM_UNIVERSITY u) {
/*  76 */     if (u.bonus().get((BOOSTABLE_O)h.indu()) <= 0.0D)
/*  77 */       return false; 
/*  78 */     return (STATS.EDUCATION()).adult.educateCan(h.indu());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public AIPLAN.AiPlanActivation getPlan(Humanoid a, AIManager d) {
/*  84 */     return this.plan.activate(a, d);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void init(Humanoid a, AIManager d, HTYPE prev, HTYPE current) {
/*  89 */     ROOM_UNIVERSITY u = getFirstUni(a, d);
/*  90 */     u.emp.employ(a);
/*     */   }
/*     */   
/*  93 */   private static double lls = 0.0625D;
/*     */ 
/*     */   
/*     */   protected void update(Humanoid a, AIManager d, boolean newDay, int byteDelta, int upI) {
/*  97 */     RoomInstance in = (RoomInstance)(STATS.WORK()).EMPLOYED.get(a);
/*  98 */     if (in != null && in.blueprintI() instanceof ROOM_UNIVERSITY) {
/*  99 */       ROOM_UNIVERSITY u = (ROOM_UNIVERSITY)in.blueprintI();
/* 100 */       double ls = u.learningSpeed(in, (BOOSTABLE_O)a.indu());
/* 101 */       (STATS.EDUCATION()).adult.educate(a.indu(), ls * lls);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public int getPriority(Humanoid a, AIManager d) {
/* 107 */     if (!shouldContinue(a, d))
/* 108 */       return 0; 
/* 109 */     return ((ROOM_UNIVERSITY)((RoomInstance)(STATS.WORK()).EMPLOYED.get(a)).blueprintI()).isTime.is() ? 5 : 0;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\types\student\AIModule_Student.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */