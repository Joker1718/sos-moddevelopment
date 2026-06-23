/*     */ package init.type;
/*     */ import init.sprite.SPRITES;
/*     */ import init.sprite.UI.Icon;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.color.ColorImp;
/*     */ import snake2d.util.sets.LIST;
/*     */ import snake2d.util.sets.LISTE;
/*     */ import util.text.D;
/*     */ 
/*     */ public class HCLASSES {
/*     */   private final ArrayListGrower<HCLASS> all;
/*     */   private final ArrayListGrower<HCLASS> allP;
/*     */   
/*     */   HCLASSES() {
/*  15 */     D.gInit(this);
/*     */ 
/*     */     
/*  18 */     this.all = new ArrayListGrower();
/*  19 */     this.allP = new ArrayListGrower();
/*     */     
/*  21 */     this.map = new KeyMap();
/*  22 */     this.NOBLE = new HCLASS((LISTE)this.all, (LISTE)this.allP, 
/*  23 */         "NOBLE", 
/*  24 */         D.g("Noble"), D.g("Nobilities"), 
/*  25 */         D.g("NobilityD", "The Nobility are the top social layer of your kingdom. They do not work traditionally and demand a salary amongst high tier services. The rewards for having nobles around can be great however."), 
/*  26 */         true, (COLOR)new ColorImp(3, 1, 19))
/*     */       {
/*     */         public Icon icon()
/*     */         {
/*  30 */           return (SPRITES.icons()).m.noble;
/*     */         }
/*     */ 
/*     */         
/*     */         public Icon iconSmall() {
/*  35 */           return (Icon)(SPRITES.icons()).s.noble;
/*     */         }
/*     */       };
/*     */     
/*  39 */     this.CITIZEN = new HCLASS((LISTE)this.all, (LISTE)this.allP, 
/*  40 */         "CITIZEN", 
/*  41 */         D.g("Plebeian"), D.g("Plebeians"), 
/*  42 */         D.g("PlebeianD", "Plebeians are the bulk of your population and will carry out your wishes."), 
/*  43 */         true, (COLOR)new ColorImp(3, 1, 19))
/*     */       {
/*     */         public Icon icon()
/*     */         {
/*  47 */           return (SPRITES.icons()).m.citizen;
/*     */         }
/*     */ 
/*     */         
/*     */         public Icon iconSmall() {
/*  52 */           return (Icon)(SPRITES.icons()).s.citizen;
/*     */         }
/*     */       };
/*     */     
/*  56 */     this.SLAVE = new HCLASS((LISTE)this.all, (LISTE)this.allP, 
/*  57 */         "SLAVE", 
/*  58 */         D.g("Slave"), D.g("Slaves"), 
/*  59 */         D.g("SlaveD", "Slaves do mundane and hard work, but need little in return. They can not be trained into soldiers, or be educated, or replicated, but are gained through processing your captives. If you mistreat slaves they may revolt."), 
/*  60 */         true, (COLOR)new ColorImp(20, 20, 8))
/*     */       {
/*     */         public Icon icon()
/*     */         {
/*  64 */           return (SPRITES.icons()).m.slave;
/*     */         }
/*     */ 
/*     */         
/*     */         public Icon iconSmall() {
/*  69 */           return (Icon)(SPRITES.icons()).s.slave;
/*     */         }
/*     */       };
/*     */ 
/*     */ 
/*     */     
/*  75 */     for (HCLASS cl : this.all) {
/*  76 */       this.map.put(cl.key, cl);
/*     */     }
/*     */     
/*  79 */     this.OTHER = new HCLASS((LISTE)this.all, (LISTE)this.allP, 
/*  80 */         "OTHER", 
/*  81 */         "Other", "Others", 
/*  82 */         "", 
/*  83 */         false, (COLOR)new ColorImp(20, 20, 8))
/*     */       {
/*     */         public Icon icon()
/*     */         {
/*  87 */           return (SPRITES.icons()).m.citizen;
/*     */         }
/*     */ 
/*     */         
/*     */         public Icon iconSmall() {
/*  92 */           return (Icon)(SPRITES.icons()).s.human;
/*     */         }
/*     */       };
/*     */ 
/*     */     
/*  97 */     this.MAP = new RMAPS("CLASS", (LIST)this.all);
/*     */ 
/*     */     
/* 100 */     self = this;
/*     */   }
/*     */   private final KeyMap<HCLASS> map; private final HCLASS NOBLE; private final HCLASS CITIZEN; private final HCLASS SLAVE; private final HCLASS OTHER; private final RMAPS<HCLASS> MAP;
/*     */   private static HCLASSES self;
/*     */   
/*     */   public static HCLASS NOBLE() {
/* 106 */     return self.NOBLE;
/*     */   }
/*     */   public static HCLASS CITIZEN() {
/* 109 */     return self.CITIZEN;
/*     */   }
/*     */   public static HCLASS SLAVE() {
/* 112 */     return self.SLAVE;
/*     */   }
/*     */   public static HCLASS OTHER() {
/* 115 */     return self.OTHER;
/*     */   }
/*     */   public static RMAPS<HCLASS> MAP() {
/* 118 */     return self.MAP;
/*     */   }
/*     */   
/*     */   public static LIST<HCLASS> ALL() {
/* 122 */     return (LIST<HCLASS>)self.all;
/*     */   }
/*     */   
/*     */   public static LIST<HCLASS> ALLP() {
/* 126 */     return (LIST<HCLASS>)self.allP;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\init\type\HCLASSES.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */