/*     */ package init.sprite.UI;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import snake2d.CORE;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.color.ColorImp;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.sets.ArrayListGrower;
/*     */ import snake2d.util.sprite.SPRITE;
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
/*     */ public class S
/*     */   extends IconMaker
/*     */ {
/*     */   int i;
/*     */   public final IconS magnifier;
/*     */   public final IconS minifier;
/*     */   public final IconS minimap;
/*     */   public final IconS arrowUp;
/*     */   public final IconS arrowDown;
/*     */   public final IconS cancel;
/*     */   public final IconS camera;
/*     */   public final IconS crazy;
/*     */   public final IconS menu;
/*     */   public final IconS cog;
/*     */   public final IconS question;
/*     */   public final IconS storage;
/*     */   public final IconS magnifierBig;
/*     */   public final IconS minifierBig;
/*     */   public final IconS human;
/*     */   public final IconS hammer;
/*     */   public final IconS column;
/*     */   public final IconS vial;
/*     */   public final IconS gift;
/*     */   public final IconS plate;
/*     */   public final IconS sword;
/*     */   public final IconS money;
/*     */   public final IconS crossheir;
/*     */   public final IconS standard;
/*     */   public final IconS temperature;
/*     */   public final IconS eye;
/*     */   public final IconS law;
/*     */   public final IconS pickaxe;
/*     */   public final IconS shield;
/*     */   public final IconS capitol;
/*     */   public final IconS sprout;
/*     */   public final IconS trade;
/*     */   public final IconS bow;
/*     */   public final IconS fish;
/*     */   public final IconS heart;
/*     */   public final IconS citizen;
/*     */   public final IconS slave;
/*     */   public final IconS noble;
/*     */   public final IconS world;
/*     */   public final IconS admin;
/*     */   public final IconS muster;
/*     */   public final IconS time;
/*     */   public final IconS ice;
/*     */   public final IconS heat;
/*     */   public final IconS pluses;
/*     */   public final IconS squatter;
/*     */   public final IconS fly;
/*     */   public final IconS honor;
/*     */   public final IconS bed;
/*     */   public final IconS alert;
/*     */   public final IconS arrow_right;
/*     */   public final IconS arrow_left;
/*     */   public final IconS plus;
/*     */   public final IconS minus;
/*     */   public final IconS allRight;
/*     */   public final IconS circle;
/*     */   public final IconS clock;
/*     */   public final IconS death;
/*     */   public final IconS dot;
/*     */   public final IconS house;
/*     */   public final IconS degrade;
/*     */   public final IconS fist;
/*     */   public final IconS armour;
/*     */   public final IconS handOpen;
/*     */   public final IconS speed;
/*     */   public final IconS boom;
/*     */   public final IconS drop;
/*     */   public final IconS star;
/*     */   public final IconS ship;
/*     */   public final IconS[] chevrons;
/*     */   public final IconS happy;
/*     */   public final IconS soso;
/*     */   public final IconS angry;
/*     */   public final SPRITE[] faces;
/*     */   public final IconS crown;
/*     */   public final IconS flags;
/*     */   public final IconS expand;
/*     */   public final IconS wheel;
/*     */   public final IconS flag;
/*     */   public final IconS cameraBig;
/*     */   public final IconS tolerence;
/*     */   public final IconS headspike;
/*     */   public final IconS jug;
/*     */   public final IconS bars;
/*     */   public final IconS shrine;
/*     */   public final IconS temple;
/*     */   public final IconS book;
/*     */   public final IconS plus2;
/*     */   public final IconS plusBig;
/*     */   public final IconS copy;
/*     */   public final IconS smallSkull;
/*     */   public final IconS divWalk;
/*     */   public final IconS divRun;
/*     */   public final IconS typeCitizen;
/*     */   public final IconS typeRetire;
/*     */   public final IconS typeRecruit;
/*     */   public final IconS typeSoldier;
/*     */   public final IconS typeStudent;
/*     */   public final IconS typePrison;
/*     */   public final IconS typeTourist;
/*     */   public final IconS typeRioter;
/*     */   public final IconS typeCrazy;
/*     */   public final IconS typeChild;
/*     */   public final IconS typeParent;
/*     */   public final IconS reproduction;
/* 453 */   private static ArrayListGrower<IconS> all = new ArrayListGrower();
/*     */   
/*     */   public final IconS typeGuard;
/*     */   public final IconS trust;
/*     */   public final IconS emissary;
/*     */   
/*     */   private S() throws IOException {
/* 460 */     super("16", 16);
/*     */     
/*     */     all.clear();
/* 463 */     this.i = 0;
/*     */ 
/*     */     
/* 466 */     this.magnifier = get();
/* 467 */     this.minifier = get();
/* 468 */     this.minimap = get();
/* 469 */     this.arrowUp = get();
/*     */     
/* 471 */     this.arrowDown = get();
/* 472 */     this.cancel = get();
/* 473 */     this.camera = get();
/* 474 */     this.crazy = get();
/*     */     
/* 476 */     this.menu = get();
/* 477 */     this.cog = get();
/* 478 */     this.question = get();
/* 479 */     this.storage = get();
/*     */     
/* 481 */     this.magnifierBig = get();
/* 482 */     this.minifierBig = get();
/* 483 */     this.human = get();
/* 484 */     this.hammer = get();
/*     */     
/* 486 */     this.column = get();
/* 487 */     this.vial = get();
/* 488 */     this.gift = get();
/* 489 */     this.plate = get();
/*     */     
/* 491 */     this.sword = get();
/* 492 */     this.money = get();
/* 493 */     this.crossheir = get();
/* 494 */     this.standard = get();
/*     */     
/* 496 */     this.temperature = get();
/* 497 */     this.eye = get();
/* 498 */     this.law = get();
/* 499 */     this.pickaxe = get();
/*     */     
/* 501 */     this.shield = get();
/* 502 */     this.capitol = get();
/* 503 */     this.sprout = get();
/* 504 */     this.trade = get();
/*     */     
/* 506 */     this.bow = get();
/* 507 */     this.fish = get();
/* 508 */     this.heart = get();
/* 509 */     this.citizen = get();
/*     */     
/* 511 */     this.slave = get();
/* 512 */     this.noble = get();
/* 513 */     this.world = get();
/* 514 */     this.admin = get();
/*     */     
/* 516 */     this.muster = get();
/* 517 */     this.time = get();
/* 518 */     this.ice = get();
/* 519 */     this.heat = get();
/*     */     
/* 521 */     this.pluses = get();
/* 522 */     this.squatter = get();
/* 523 */     this.fly = get();
/* 524 */     this.honor = get();
/*     */     
/* 526 */     this.bed = get();
/* 527 */     this.alert = get();
/* 528 */     this.arrow_right = get();
/* 529 */     this.arrow_left = get();
/*     */     
/* 531 */     this.plus = get();
/* 532 */     this.minus = get();
/* 533 */     this.allRight = get();
/* 534 */     this.circle = get();
/*     */     
/* 536 */     this.clock = get();
/* 537 */     this.death = get();
/* 538 */     this.dot = get();
/* 539 */     this.house = get();
/*     */     
/* 541 */     this.degrade = get();
/* 542 */     this.fist = get();
/* 543 */     this.armour = get();
/* 544 */     this.handOpen = get();
/* 545 */     this.speed = get();
/*     */     
/* 547 */     this.boom = get();
/* 548 */     this.drop = get();
/* 549 */     this.star = get();
/* 550 */     this.ship = get();
/* 551 */     this
/*     */ 
/*     */ 
/*     */       
/* 555 */       .chevrons = new IconS[] { get(), get(), get(), get() };
/*     */ 
/*     */     
/* 558 */     this.happy = get();
/* 559 */     this.soso = get();
/* 560 */     this.angry = get();
/* 561 */     this
/*     */ 
/*     */       
/* 564 */       .faces = new SPRITE[] { this.angry.createColored((COLOR)new ColorImp(165, 30, 30)), this.soso.createColored((COLOR)new ColorImp(165, 165, 10)), this.happy.createColored((COLOR)new ColorImp(30, 165, 30)) };
/*     */ 
/*     */     
/* 567 */     this.crown = get();
/* 568 */     this.flags = get();
/* 569 */     this.expand = get();
/* 570 */     this.wheel = get();
/* 571 */     this.flag = get();
/* 572 */     this.cameraBig = get();
/* 573 */     this.tolerence = get();
/* 574 */     this.headspike = get();
/* 575 */     this.jug = get();
/* 576 */     this.bars = get();
/* 577 */     this.shrine = get();
/* 578 */     this.temple = get();
/* 579 */     this.book = get();
/* 580 */     this.plus2 = get();
/* 581 */     this.plusBig = get();
/* 582 */     this.copy = get();
/* 583 */     this.smallSkull = get();
/* 584 */     this.divWalk = get();
/* 585 */     this.divRun = get();
/*     */     
/* 587 */     this.typeCitizen = get();
/* 588 */     this.typeRetire = get();
/* 589 */     this.typeRecruit = get();
/* 590 */     this.typeSoldier = get();
/* 591 */     this.typeStudent = get();
/* 592 */     this.typePrison = get();
/* 593 */     this.typeTourist = get();
/* 594 */     this.typeRioter = get();
/* 595 */     this.typeCrazy = get();
/* 596 */     this.typeChild = get();
/* 597 */     this.typeParent = get();
/*     */     
/* 599 */     this.reproduction = get();
/*     */     
/* 601 */     this.typeGuard = get();
/* 602 */     this.trust = get();
/* 603 */     this.emissary = get();
/*     */   }
/*     */   public IconS chevron(DIR d) {
/* 606 */     return this.chevrons[d.orthoID()];
/*     */   }
/*     */   
/*     */   private IconS get() throws IOException {
/* 610 */     int k = this.i;
/* 611 */     this.i++;
/*     */     
/* 613 */     return new IconS(get("_Icons", k));
/*     */   }
/*     */   
/* 616 */   private static final COLOR mask = (COLOR)new ColorImp(142, 134, 107);
/*     */   
/*     */   public static class IconS
/*     */     extends Icon {
/*     */     public final int index;
/*     */     
/*     */     IconS(Icon i) {
/* 623 */       super(16, i);
/* 624 */       this.index = Icons.S.all.add(this);
/*     */     }
/*     */ 
/*     */     
/*     */     public void render(SPRITE_RENDERER r, int X1, int X2, int Y1, int Y2) {
/* 629 */       COLOR c = CORE.renderer().colorGet();
/* 630 */       if (c.red() == Byte.MAX_VALUE && c.green() == Byte.MAX_VALUE && c.blue() == Byte.MAX_VALUE) {
/* 631 */         Icons.S.mask.bind();
/* 632 */         super.render(r, X1, X2, Y1, Y2);
/* 633 */         COLOR.unbind();
/*     */       }
/*     */       else {
/*     */         
/* 637 */         super.render(r, X1, X2, Y1, Y2);
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IconS get(int index) {
/* 646 */     if (index > all.size())
/* 647 */       return this.cancel; 
/* 648 */     return (IconS)all.get(index);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\init\sprite\UI\Icons$S.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */