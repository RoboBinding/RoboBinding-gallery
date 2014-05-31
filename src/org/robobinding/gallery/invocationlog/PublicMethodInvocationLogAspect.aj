package org.robobinding.gallery.invocationlog;

import org.aspectj.lang.annotation.AdviceName;


/**
 *
 * @since 1.0
 * @version $Revision: 1.0 $
 * @author Cheng Wei
 */
public aspect PublicMethodInvocationLogAspect
{
	pointcut publicMethods() : execution (public * PublicMethodInvocationLog+.*(..));

	@AdviceName("logInvocation")
	after () : publicMethods()
	{
		System.out.println(thisJoinPointStaticPart.getSignature()+" invoked");
	}
}
