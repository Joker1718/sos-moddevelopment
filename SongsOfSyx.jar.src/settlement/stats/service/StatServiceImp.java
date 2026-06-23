/*     */ package settlement.stats.service;
/*     */ 
/*     */ import init.race.RACES;
/*     */ import init.race.Race;
/*     */ import init.type.HCLASSES;
/*     */ import init.type.HCLASS_RACE;
/*     */ import init.type.HTYPES;
/*     */ import init.type.NEED;
/*     */ import java.io.IOException;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.stats.StatsInit;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.file.SAVABLE;
/*     */ import snake2d.util.sets.Bitmap1D;
/*     */ import snake2d.util.sets.LISTE;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.data.BOOLEANO;
/*     */ import util.info.INFO;
/*     */ import util.text.D;
/*     */ 
/*     */ 
/*     */ public abstract class StatServiceImp
/*     */   extends StatService
/*     */ {
/*     */   public static final int TARGET_MAX = 16;
/*     */   private final Perm permission;
/*  28 */   static CharSequence ¤¤Access = "¤Access";
/*  29 */   static CharSequence ¤¤AcessDesc = "¤The level of access this subject has to a service. Can be improved by building more service facilities and making sure they are close enough for your people to utilize.";
/*  30 */   static CharSequence ¤¤Quality = "¤Quality";
/*  31 */   static CharSequence ¤¤QualityDesc = "¤The quality of a subject's last visit to this facility. Often improved by placing special items in the rooms in question.";
/*  32 */   static CharSequence ¤¤Distance = "¤Proximity";
/*  33 */   static CharSequence ¤¤DistanceDesc = "¤Whenever a subject wants to use a service, this is the distance the subject has had to walk to reach it. This value only reaches 100% if subjects are right next to the service at all times. You must yourself find a good balance.";
/*  34 */   static CharSequence ¤¤TotalDesc = "¤The access and quality this subject group has. Can be improved by building more facilities, keeping them maintained, and also in some cases building them well.";
/*  35 */   static CharSequence ¤¤UpDesc = "¤The current upgrade boost from the rooms visited. Some rooms don't have upgrades.";
/*     */   
/*  37 */   private static CharSequence ¤¤perm = "¤Permission";
/*     */   static {
/*  39 */     D.ts(StatServiceImp.class);
/*     */   }
/*     */   
/*     */   StatServiceImp(String key, LISTE<StatServiceImp> all, StatsInit init, CharSequence name, CharSequence desc, SPRITE icon, NEED need) {
/*  43 */     super(name, desc, icon, need);
/*  44 */     all.add(this);
/*  45 */     this.permission = new Perm(¤¤perm, String.valueOf(¤¤perm) + ": " + String.valueOf(¤¤perm));
/*  46 */     init.savers.put("SER_PERM_" + key, this.permission);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public BOOLEANO.BOOLEAN_OE<HCLASS_RACE> permission() {
/*  52 */     return this.permission;
/*     */   }
/*     */ 
/*     */   
/*     */   public double getBasePriority(Humanoid h) {
/*  57 */     return h.indu().race().stats().defNormalized((h.indu().hType()).CLASS, total().standing());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean accessRequest(Humanoid h) {
/*  65 */     if (h.indu().hType() == HTYPES.NOBILITY())
/*  66 */       return true; 
/*  67 */     if (h.indu().hType() == HTYPES.TOURIST())
/*  68 */       return true; 
/*  69 */     if (h.indu().hType().parent() != h.indu().hType()) {
/*  70 */       if (!((total()).standing.definition(h.race())).child)
/*  71 */         return false; 
/*  72 */       return this.permission.is(HCLASS_RACE.clP(h.race(), h.indu().hType().parent().parentClass()));
/*     */     } 
/*  74 */     return this.permission.is(h.indu().popCL());
/*     */   }
/*     */   
/*     */   private class Perm
/*     */     implements BOOLEANO.BOOLEAN_OE<HCLASS_RACE>, SAVABLE {
/*  79 */     private final Bitmap1D access = new Bitmap1D(HCLASS_RACE.ALL().size(), false);
/*     */     private final INFO info;
/*     */     
/*     */     public Perm(CharSequence name, CharSequence desc) {
/*  83 */       this.info = new INFO(name, desc);
/*     */     }
/*     */ 
/*     */     
/*     */     public INFO info() {
/*  88 */       return this.info;
/*     */     }
/*     */ 
/*     */     
/*     */     public void save(FilePutter file) {
/*  93 */       this.access.save(file);
/*     */     }
/*     */ 
/*     */     
/*     */     public void load(FileGetter file) throws IOException {
/*  98 */       this.access.load(file);
/*     */     }
/*     */ 
/*     */     
/*     */     public void clear() {
/* 103 */       for (HCLASS_RACE p : HCLASS_RACE.ALL()) {
/* 104 */         if (StatServiceImp.this instanceof StatServiceChild)
/* 105 */           this.access.set(p.index, true); 
/* 106 */         if (p.cl != null && p.race != null) {
/* 107 */           boolean b = (p.cl != HCLASSES.SLAVE() && (StatServiceImp.this.total()).boosters.all().size() > 0);
/* 108 */           int i = b | ((StatServiceImp.this.total().standing().max(p.cl, p.race) != 0.0D) ? 1 : 0);
/* 109 */           this.access.set(p.index, !(i != 0));
/*     */         } 
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean is(HCLASS_RACE t) {
/* 116 */       if (t.race == null) {
/* 117 */         boolean m = false;
/* 118 */         for (Race r : RACES.all()) {
/* 119 */           m |= is(t.cl.get(r));
/*     */         }
/* 121 */         return m;
/*     */       } 
/* 123 */       return !this.access.get(t.index());
/*     */     }
/*     */ 
/*     */     
/*     */     public BOOLEANO.BOOLEAN_OE<HCLASS_RACE> set(HCLASS_RACE t, boolean b) {
/* 128 */       if (t.race == null) {
/* 129 */         for (Race r : RACES.all()) {
/* 130 */           set(t.cl.get(r), b);
/*     */         }
/*     */       } else {
/* 133 */         this.access.set(t.index(), !b);
/* 134 */       }  return this;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\stats\service\StatServiceImp.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */